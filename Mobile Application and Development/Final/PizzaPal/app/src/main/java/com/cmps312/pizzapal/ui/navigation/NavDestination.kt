package com.cmps312.pizzapal.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDestination (
    val route: String,
    val title: String,
    val icon: ImageVector? = null,
    val drawable: Int? = null
) {
    object OrderEditor : NavDestination("orderEditor", "Order Editor" )

    object OrderScreen : NavDestination("orderScreen", "Order Screen" )

    object OrderItemEditor : NavDestination("orderItemEditor", "Order Item Editor" )

    object OrderItemScreen : NavDestination("orderItemScreen", "Order Item Screen" )



}