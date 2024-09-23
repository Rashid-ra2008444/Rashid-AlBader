package com.example.quickmart.ui.product

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quickmart.R
import com.example.quickmart.data.model.CartItem
import com.example.quickmart.data.model.Product
import com.example.quickmart.viewModel.CartViewModel
import com.example.quickmart.viewModel.FavouriteViewModel
import com.example.quickmart.viewModel.ProductViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ProductDetailsScreen(
    navController: NavHostController,
    productId: String,
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel,
    favouriteViewModel: FavouriteViewModel
) {
    val context = LocalContext.current
    val product = productViewModel.getProduct(productId)

    Log.d("Product" , productId)

    LaunchedEffect(Unit) {
        productViewModel.initProductList(context)
    }
    val cartItems by cartViewModel.getCartItems().collectAsState(initial = emptyList())
    val cartItem = cartItems.find { it.productId == productId }

    val onDecreaseQuantity: (CartItem) -> Unit = { item ->
        cartViewModel.updateItem(item.productId,  - 1)
    }
    val onIncreaseQuantity: (CartItem) -> Unit = { item ->
        cartViewModel.updateItem(item.productId,  1)
    }
    val onAddProductToCart: (Product) -> Unit = { prod ->
        cartViewModel.addCartItem(CartItem(productId = prod.id , quantity = 0 ))
    }


    product?.let {  nonNullProduct->
        ProductDetailsCard(
            product = nonNullProduct,
            navController = navController,
            item = cartItem ?: CartItem(productId = productId, quantity = 1 ),
            onDecreaseQuantity = onDecreaseQuantity,
            onIncreaseQuantity = onIncreaseQuantity,
            onAddProductToCart = onAddProductToCart,
            productViewModel = productViewModel,
            favouriteViewModel = favouriteViewModel
        )
    }
    product?.toString()?.let { Log.d("ProductTransfer", it) }
}
@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsCard(
    product: Product,
    navController: NavHostController,
    item: CartItem,
    onDecreaseQuantity: (CartItem) -> Unit,
    onIncreaseQuantity: (CartItem) -> Unit,
    onAddProductToCart: (Product) -> Unit,
    favouriteViewModel: FavouriteViewModel,
    productViewModel: ProductViewModel
) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* TopAppBar content */ },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle share action */ }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = {
                    onAddProductToCart(product)
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text("Add to Basket")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = imageResource(imageName = product.imageName)),
                    contentDescription = null,
                    modifier = Modifier
                        .size(240.dp)
                        .align(Alignment.Center)
                )
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween ,modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                )
                IconButton(onClick = {
                    if (count <1) {
                        favouriteViewModel.addToFavourites(product)
                        Toast.makeText(
                            context,
                            "Added ${product.title} to favorite",
                            Toast.LENGTH_SHORT
                        ).show()
                        count++
                    }
                    else {
                        Toast.makeText(
                            context,
                            "${product.title} already added to favorite",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }) {
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                }
            }
                Text(
                    text = "1 KG, Price",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuantitySelector(item, onDecreaseQuantity, onIncreaseQuantity)
                    Text(
                        text = "QR ${item.calculateTotalPrice().formatAsCurrency()}",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                Divider()
                ExpandableCard(product = product)
                Divider()


            }
        }
    }


    @Composable
    fun QuantitySelector(
        item: CartItem,
        onDecreaseQuantity: (CartItem) -> Unit,
        onIncreaseQuantity: (CartItem) -> Unit
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { onDecreaseQuantity(item) }) {
                Icon(
                    painterResource(R.drawable.baseline_remove_24),
                    contentDescription = "Decrease"
                )
            }
            Text(
                text = item.quantity.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            IconButton(onClick = { onIncreaseQuantity(item) }) {
                Icon(Icons.Default.Add, contentDescription = "Increase")
            }
        }
    }

    @SuppressLint("DiscouragedApi")
    @Composable
    fun imageResource(imageName: String): Int {
        return LocalContext.current.resources.getIdentifier(
            imageName, "drawable", LocalContext.current.packageName
        )
    }

    fun Double.formatAsCurrency(): String {
        return String.format("%.2f", this)
    }

    @Composable
    fun ExpandableCard(product: Product) {

        var expanded by remember { mutableStateOf(false) }

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    expanded = !expanded
                }
        ) {
            Column(
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Product Details:",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    var iconChanger: Unit = if (!expanded) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
                if (expanded) {
                    Text(
                        text = product.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
