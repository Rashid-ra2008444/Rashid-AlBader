package com.cmps312.pizzapal.ui.navigation

import OrderScreen
import androidx.activity.ComponentActivity
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.pizzapal.entity.Pizza
import com.cmps312.pizzapal.ui.view.order.OrderEditor
import com.cmps312.pizzapal.ui.view.orderitem.OrderItemEditor
import com.cmps312.pizzapal.ui.view.orderitem.OrderItemScreen
import com.cmps312.pizzapal.ui.viewmodel.PizzaPalViewModel

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    val pizzaPalViewModel =
        viewModel<PizzaPalViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)


    NavHost(navController, NavDestination.OrderScreen.route, modifier = Modifier.padding(paddingValues)) {
        composable(NavDestination.OrderEditor.route, enterTransition = { slideInHorizontally() }) {
            OrderEditor(
                onSubmit = { pizzaPalViewModel.upsertOrder(it) },
                pizzaPalViewModel = pizzaPalViewModel,
                navController
            )


        }
        composable(NavDestination.OrderScreen.route, enterTransition = { slideInHorizontally { it / 2 } }) {
            OrderScreen(
                pizzaPalViewModel,
                navHostController = navController,
                onSelect =
            {
                navController.navigate(NavDestination.OrderItemScreen.route) {
                    launchSingleTop = true
                    popUpTo(NavDestination.OrderScreen.route)
                }
            })
        }
        composable(NavDestination.OrderItemEditor.route, enterTransition = { slideInHorizontally { it / 2 } }) {
            OrderItemEditor(
                onSubmitPizza = { pizzaPalViewModel.upsertPizza(it) },
                pizzaPalViewModel = pizzaPalViewModel ,
                pizza = Pizza())
        }
        composable(NavDestination.OrderItemScreen.route, enterTransition = { slideInHorizontally { it / 2 } }) {
            OrderItemScreen()
        }
    }
}