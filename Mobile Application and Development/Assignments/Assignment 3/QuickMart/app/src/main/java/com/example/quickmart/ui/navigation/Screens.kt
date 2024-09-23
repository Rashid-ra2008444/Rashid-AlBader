package com.example.quickmart.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.quickmart.R


sealed class Screens(
    val route: String,
    val title: String,
    val image: Int? = null,
    val imageVector : ImageVector? = null
) {
    //object HomeScreen: Screens("home","Home Screen")
    object ProductScreen: Screens("shop","Shop Screen",   R.drawable.baseline_storefront_24)
    object CartScreen: Screens("cart","Cart Screen", imageVector = Icons.Default.ShoppingCart)
    object FavoriteScreen: Screens("favorites","Favorites Screen", imageVector = Icons.Default.Favorite)
    object ProductDetailsScreen: Screens("productDetail", "Product Detail Screen")

    object CheckOut : Screens("checkOut","Check Out")
}


object ScreenUtil {
    fun getAllScreen()= listOf(
        //Screens.HomeScreen,
        Screens.ProductScreen,
        Screens.CartScreen,
        Screens.FavoriteScreen,
    )

}

