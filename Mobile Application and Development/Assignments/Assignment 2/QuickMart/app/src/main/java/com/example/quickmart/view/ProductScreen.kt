package com.example.quickmart.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Product
import com.example.quickmart.repo.CartRepository
import com.example.quickmart.repo.ProductRepository
import com.example.quickmart.repo.ProductRepository.productList
import com.example.quickmart.repo.ProductRepository.search
import org.intellij.lang.annotations.JdkConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(product: Product, onItem: CartRepository) {
    val imageId = LocalContext.current.resources.getIdentifier(
        product.imageName,
        "drawable",
        LocalContext.current.packageName
    )
    val cartItem = CartItem(
        productID = product.id,
        productName = product.title,
        quantity = 1,
        unitPrice = product.price
    )
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(0.5.dp, Color.LightGray, shape = RoundedCornerShape(16.dp))
            .fillMaxSize(1F),

        colors = CardDefaults.outlinedCardColors(containerColor = Color.White)


    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()

        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .size(120.dp)
            )
            Text(
                product.title,
                style = MaterialTheme
                    .typography
                    .titleMedium
            )
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.BottomCenter


            )
            {
                Row() {
                    Text("$${product.price}")
                    Spacer(modifier = Modifier.weight(1F))
                    Button(
                        onClick = { onItem.addItem(cartItem) },
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(),
                        shape = RoundedCornerShape(2.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                    }


                }
            }
        }
    }
}
@SuppressLint("RememberReturnType")
@Composable
fun ProductList(products: List<Product>,cartRepository: CartRepository = CartRepository, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(products.size) { index ->
            ProductCard(products[index], onItem = cartRepository)
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(onNavigation: (String) -> Unit) {
    val searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    var productList by remember { mutableStateOf(ProductRepository.initProduct(context)) }
    val cartRepository = remember { CartRepository }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {},
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    TopBar { productList = it }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ProductList(productList, cartRepository = cartRepository)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(updateProductList: (List<Product>)-> Unit) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var isDropdownMenuExpanded by remember { mutableStateOf(false) }
    val categoryList = listOf("All") +ProductRepository.getCategory(context)
    TextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            updateProductList(search(searchQuery))
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(),
        placeholder = { Text(text = "Search") },
        modifier = Modifier.clip(shape = RoundedCornerShape(8.dp)),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        searchQuery = ""
                        updateProductList(productList)
                    })
            }
        }
    )
    Box(modifier = Modifier) {
            IconButton(onClick = {isDropdownMenuExpanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = ""
                )
            }
        DropdownMenu(
            expanded = isDropdownMenuExpanded,
            onDismissRequest = { isDropdownMenuExpanded = false }
        ) {
            categoryList.forEach {category ->
                DropdownMenuItem(text = { Text(category , color = Color.Black) }  ,
                    onClick = {
                        selectedCategory = category
                        updateProductList(ProductRepository.getProduct(searchQuery , selectedCategory))
                        isDropdownMenuExpanded = false
                    })
            }
        }
    }
}
