package com.example.quickmart.ui.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.quickmart.viewModel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TopBar(
    query: String,
    onQueryChange: (String) ->Unit,
    searchBy: (String) -> Unit,
    filterBy: (String) -> Unit,
    categories: List<String>,
    selectedCategory: String,
    productViewModel : ProductViewModel
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
                searchBy(it)
            },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (query.isNotBlank()) {
                    Icon(Icons.Default.Clear,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.clickable {
                            searchBy(query)
                        }
                    )
                }
            },
            placeholder = { Text("Search") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.weight(1f)
        )


        CategoryFilter(
            categories = categories,
            selectedCategory = selectedCategory,
            onFilterByCategory = filterBy,
            productViewModel = productViewModel
        )
    }
}