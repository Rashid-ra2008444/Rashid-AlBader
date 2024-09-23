package com.example.quickmart.view



import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var currentScreen by remember { mutableStateOf("ProductScreen") }

    // Navigates to the given screen
    fun onNavigation(destination: Screen) {
        currentScreen = destination.toString()
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color.White) {
                IconButton(onClick = { onNavigation(Screen.ProductScreen) }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = Icons.Default.Shop, contentDescription = "Shop")
                        Text(text = "Shop", style = TextStyle(fontSize = 12.sp))
                    }
                }
                IconButton(onClick = { onNavigation(Screen.CartScreen) }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                        Text(text = "Cart", style = TextStyle(fontSize = 12.sp))
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )

        {
            when (currentScreen) {
                "ProductScreen" -> ProductScreen { onNavigation(Screen.CartScreen) }
                "CartScreen" -> CartScreen { onNavigation(Screen.ProductScreen) }
                else -> {}  // Default empty content
            }
        }
    }
}