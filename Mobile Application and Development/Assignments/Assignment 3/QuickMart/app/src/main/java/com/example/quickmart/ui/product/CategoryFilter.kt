package com.example.quickmart.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quickmart.R
import com.example.quickmart.data.model.Product
import com.example.quickmart.viewModel.ProductViewModel

@Composable
fun CategoryFilter(
    categories: List<String>,
    selectedCategory: String,
    onFilterByCategory: (String) -> Unit,
    productViewModel: ProductViewModel
) {
    var isExpanded by remember { mutableStateOf(false) }



    Row {
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(painterResource(id = R.drawable.baseline_tune_24), contentDescription = "Filter")
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            categories.forEach { category ->
                DropdownMenuItem(
                    onClick = {
                        onFilterByCategory(category)
                        isExpanded = false
                    },
                    text = { Text(text = category) }
                ) 
            }
        }
    }
}