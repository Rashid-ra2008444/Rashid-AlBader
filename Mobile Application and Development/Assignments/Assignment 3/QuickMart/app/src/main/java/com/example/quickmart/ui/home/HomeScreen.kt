package com.example.quickmart.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


import androidx.navigation.NavHostController
import com.example.quickmart.R
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.ui.cart.CartScreen
import com.example.quickmart.ui.favourite.FavouriteScreen
import com.example.quickmart.ui.navigation.AppNavHost
import com.example.quickmart.ui.navigation.ScreenUtil
import com.example.quickmart.ui.navigation.Screens
import com.example.quickmart.ui.product.ProductScreen
import com.example.quickmart.viewModel.CartViewModel
import com.example.quickmart.viewModel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val cartViewModel = CartViewModel()
    val screens = ScreenUtil.getAllScreen()
    var selectedScreen by remember { mutableStateOf(screens[0]) }

    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.White) {
            screens.forEach { screen ->
                NavigationBarItem(
                    icon = {
                        when (screen.route) {
                            "shop" -> Icon(
                                painterResource(id = R.drawable.baseline_storefront_24),
                                contentDescription = null
                            )
                            "cart" -> Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = null
                            )
                            "favorites" -> Icon(
                                Icons.Default.FavoriteBorder,
                                contentDescription = null
                            )
                        }
                    },
                    label = { Text(screen.title) },
                    selected = selectedScreen == screen,
                    onClick = {
                        selectedScreen = screen
                        navController.navigate(screen.route)
                              },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4CAF50),
                        selectedTextColor = Color(0xFF4CAF50),
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            AppNavHost(navController)
        }
    }
}


