package com.example.compose.rally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.accounts.SingleAccountScreen
import com.example.compose.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.components.RallyTabRow
import com.example.compose.rally.ui.overview.OverviewScreen
import com.example.compose.rally.ui.theme.RallyTheme



class RallyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RallyApp()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route:String) =
    this.navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id){
            saveState=true
        }
        launchSingleTop=true
        restoreState=true
}
@Composable
fun RallyApp() {
    RallyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview
        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    onTabSelected = { newScreen ->navController.navigate(newScreen.route) },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(navController = navController,
                startDestination = Overview.route,
                modifier = Modifier.padding(innerPadding)
            ){
                composable(route = Overview.route) {
                    OverviewScreen(onClickSeeAllAccounts = {navController.navigateSingleTopTo(Accounts.route)},
                        onClickSeeAllBills = {navController.navigateSingleTopTo(Bills.route)}
                    )
                }
                composable(route = Accounts.route) {
                    AccountsScreen()
                }
                composable(route = Bills.route) {
                    BillsScreen()
                }
                composable(route = "${SingleAccount.route}/{${SingleAccount.accountTypeArg}}",
                    arguments = SingleAccount.arguments
                ){
                    SingleAccountScreen()
                }
            }
            Box(Modifier.padding(innerPadding)) {
                currentScreen
            }
        }
    }
}
