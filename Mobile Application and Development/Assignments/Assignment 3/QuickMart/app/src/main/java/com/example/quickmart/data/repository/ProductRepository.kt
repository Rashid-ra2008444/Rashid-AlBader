package com.example.quickmart.data.repository

import android.content.Context
import com.example.quickmart.data.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

object ProductRepository {
    private val _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList: StateFlow<List<Product>> get() = _productList.asStateFlow()

    private val _categories = MutableStateFlow<List<String>>(emptyList())
     val categories: StateFlow<List<String>> get() = _categories.asStateFlow()

    suspend fun initProducts(context: Context) {
        if (_productList.value.isEmpty()) {
            withContext(Dispatchers.IO) {
                val productsJson =
                    context.assets.open("products.json").bufferedReader().use { it.readText() }
                val products: List<Product> = Json.decodeFromString(productsJson)
                _productList.value = products
            }
        }
    }

    fun getProductCategories(context: Context) {
        if (_categories.value.isEmpty()) {
                val categoriesJson =
                    context.assets.open("product-categories.json").bufferedReader().use { it.readText() }

                val categoriesList: List<String> = Json.decodeFromString(
                    ListSerializer(String.serializer()), categoriesJson
                ).toMutableList().apply {
                    add(0, "All")
                }
                _categories.value = categoriesList
            }
        }


    fun getProduct(productId: String): Product? {
        return _productList.value.find { it.id == productId }
    }

    fun getProducts(name: String, category: String = "All"): List<Product> {
        val products = _productList.value
        val filteredProducts = when (category) {
            "All" -> products
            else -> products.filter { it.category.equals(category, ignoreCase = true) }
        }
        return filteredProducts.filter { it.title.contains(name, ignoreCase = true) }
    }

}
