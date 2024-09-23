package com.example.quickmart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickmart.ui.cart.CartScreen
import com.example.quickmart.ui.cart.Checkout
import com.example.quickmart.ui.favourite.FavouriteScreen
import com.example.quickmart.ui.home.HomeScreen
import com.example.quickmart.ui.product.ProductDetailsScreen
import com.example.quickmart.ui.product.ProductScreen
import com.example.quickmart.viewModel.CartViewModel
import com.example.quickmart.viewModel.FavouriteViewModel
import com.example.quickmart.viewModel.ProductViewModel


@Composable
fun AppNavHost(navController: NavHostController) {
    val cartViewModel : CartViewModel = viewModel()
    val productViewModel : ProductViewModel = viewModel()
    val favouriteViewModel : FavouriteViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screens.ProductScreen.route ) {

//        composable(route = Screens.HomeScreen.route){
//            HomeScreen(navController = navController)
//        }
        composable(route = Screens.ProductScreen.route){
            ProductScreen(navController = navController , cartViewModel , productViewModel)
        }
        composable(route = Screens.CartScreen.route){
            val onCheckOut :Unit? = null
            CartScreen(navController = navController , onCheckOut = { onCheckOut } , cartViewModel , productViewModel)
        }
        composable(route = Screens.FavoriteScreen.route){
            FavouriteScreen(navController = navController)
        }


        composable(route = Screens.ProductDetailsScreen.route + "/{productId}"){backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId").toString()
            ProductDetailsScreen(navController = navController , productId = productId , cartViewModel, productViewModel, favouriteViewModel)
        }

        composable(route = Screens.CheckOut.route) {
            Checkout(navController = navController)
        }

    }

}