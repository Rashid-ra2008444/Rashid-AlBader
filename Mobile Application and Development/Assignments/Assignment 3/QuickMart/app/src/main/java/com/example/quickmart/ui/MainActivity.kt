package com.example.quickmart.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.quickmart.data.repository.ProductRepository
import com.example.quickmart.ui.home.HomeScreen
import com.example.quickmart.ui.navigation.AppNavHost
import com.example.quickmart.ui.theme.QuickMartTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            QuickMartTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Coroutine launched to call suspend function
                    lifecycleScope.launch {
                        ProductRepository.initProducts(this@MainActivity)
                    }
                    HomeScreen(navController = navController)
                }
            }
        }
    }
}
