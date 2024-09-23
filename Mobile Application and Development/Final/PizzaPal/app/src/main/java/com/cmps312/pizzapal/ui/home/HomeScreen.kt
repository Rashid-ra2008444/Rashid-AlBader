package com.cmps312.pizzapal.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cmps312.pizzapal.ui.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val screens = listOf("orderScreen", "orderItemScreen")

    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.White) {
        screens.forEach {
            NavigationBarItem(
                (currentDestination?.route ?: "Order") == it,
                onClick = { navController.navigate(it) { launchSingleTop = true } },
                icon = {
                    when (it) {
                        "orderScreen" -> Icon(
                            imageVector = Icons.Default.Home,
                            null,
                            Modifier.size(30.dp)
                        )

                        "orderItemScreen" -> Icon(Icons.Outlined.ShoppingCart, null, Modifier.size(30.dp))
                    }
                },
                label = { Text(it) },
            )
        }
    }}) { AppNavHost(navController , it) }
}
