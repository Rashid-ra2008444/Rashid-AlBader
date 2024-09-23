package com.example.newsapp.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.Articles.repo.CategoryOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropDown(selectedOption: String, onSelectedOptionChange: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    val categories = listOf(
        CategoryOptions.None,
        CategoryOptions.BUSINESS,
        CategoryOptions.POLITICS,
        CategoryOptions.TECHNOLOGY
    )
    var selectedCategory by remember { mutableStateOf(selectedOption) }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it }) {
        TextField(value = selectedCategory,
            onValueChange = { selectedCategory = it },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            readOnly = true
        )
        ExposedDropdownMenu(expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {

            categories.forEach { category ->
                DropdownMenuItem( text = { Text(text = category)},
                    onClick = {
                    isExpanded = false
                    selectedCategory = category
                    onSelectedOptionChange(category)
                }
                )
            }

        }
    }
}





