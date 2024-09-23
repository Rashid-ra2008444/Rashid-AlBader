package com.example.quickmart.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExposureNeg1
import androidx.compose.material.icons.filled.ExposurePlus1
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Product
import com.example.quickmart.repo.CartRepository
import com.example.quickmart.repo.ProductRepository


@Composable
fun CartItemCard(
    product: Product,
    cartItem: CartItem,
    onUpdateQuantity: (String, Int)->Unit,
    onRemoveItem:(String)->Unit
) {
    val imageId = LocalContext.current.resources.getIdentifier(
        product.imageName,
        "drawable",
        LocalContext.current.packageName
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))  // Adds some space

            Column(
                modifier = Modifier.weight(3f)
            ) {
                Text(text = product.title)
                Text(text = "${product.description}, Price: ${product.price}")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        if (cartItem.quantity > 1) {
                            onUpdateQuantity(product.id, cartItem.quantity-1)
                        }
                    }) {
                        Icon(imageVector = Icons.Default.ExposureNeg1, contentDescription = "", tint = Color.Red)
                    }

                    Text(text = cartItem.quantity.toString(), fontWeight = FontWeight.Bold)

                    IconButton(onClick = {
                        onUpdateQuantity(product.id, cartItem.quantity+1)
                    } ){
                        Icon(imageVector = Icons.Default.ExposurePlus1, contentDescription = null , tint = Color.Red)
                    }

                    Text("$${String.format("%.2f", cartItem.calculateTotalPrice())}")

                    IconButton(onClick = { onRemoveItem(product.id) }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        }

    }
}

@Composable
fun CartScreen(onNavigation: (String) -> Unit) {
    val cartItemsState = remember { mutableStateOf(CartRepository.cartItems.toList()) }
    val totalPrice = cartItemsState.value.sumOf { it.calculateTotalPrice() }.let {
        String.format("%.2f", it)
    }
    val products = ProductRepository.productList


    //This function's job is to update the quantity of a specific product in a shopping cart.
    //First, it looks for the product in the current list of cart items.
    //If it finds the product, it updates its quantity.
    //It then tells  Cart repository to also update this quantity.
    //Finally, it refreshes the local list of cart items from this repository.
    val onUpdateQuantity: (String, Int) -> Unit = { productId, newQuantity ->
        val index = cartItemsState.value.indexOfFirst { it.productID == productId }
        if (index != -1) {
            val updatedCartItem = cartItemsState.value[index].copy(quantity = newQuantity)
            cartItemsState.value = cartItemsState.value.toMutableList().apply {
                this[index] = updatedCartItem
            }
        }
        CartRepository.updateItem(productId, newQuantity)
        cartItemsState.value = CartRepository.cartItems.toList()
    }

    val onRemoveItem: (String) -> Unit = { productId ->
        CartRepository.cartItems.removeIf { it.productID == productId }
        cartItemsState.value = CartRepository.cartItems.toList()  // Update the state after removal
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp)
        ) {
            items(cartItemsState.value) { cartItem ->
                val product = ProductRepository.productList.find { it.id == cartItem.productID }
                product?.let {
                    CartItemCard(product, cartItem, onUpdateQuantity,onRemoveItem)
                }
            }
        }
            Button(modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
                onClick = {}
            ) {
                Text(text = "Go to Checkout $$totalPrice")
            }
        Spacer(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().height(56.dp))
    }
}
@Composable
fun CartItems(
    cartItems: List<Pair<Product, CartItem>>,
    onUpdateQuantity: (String, Int) -> Unit,
    onRemoveItem: (String) -> Unit
) {
    LazyColumn {
        items(cartItems) { (product, cartItem) ->
            CartItemCard(product, cartItem, onUpdateQuantity,onRemoveItem)
        }
    }
}