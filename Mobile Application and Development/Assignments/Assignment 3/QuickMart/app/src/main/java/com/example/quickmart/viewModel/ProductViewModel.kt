package com.example.quickmart.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.ProductRepository
import com.example.quickmart.data.repository.ProductRepository.productList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {
    private val productRepository = ProductRepository
    val products: StateFlow<List<Product>> = productRepository.productList
    val categories: StateFlow<List<String>> = productRepository.categories
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    private var currentCategory = "All"
    private var currentQuery = ""
    private val _query = MutableStateFlow("")
    private val _selectedCategory = MutableStateFlow("All")
    private val _singleProduct = MutableStateFlow<Product?>(null)

    val singleProduct: StateFlow<Product?> get() = _singleProduct.asStateFlow()

    val filteredProducts = combine(
        _query,
        _selectedCategory,
        productList
    ) { query, category, products ->
        filterProducts(products, query, category)
    }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun setQuery(query: String) {
        _query.value = query
    }

    fun setCategory(category: String) {
        _selectedCategory.value = category
    }
    fun initProductList(context: Context) = viewModelScope.launch {
        productRepository.initProducts(context)
    }

     fun getProductCategories(context: Context) {
        viewModelScope.launch {  productRepository.getProductCategories(context)}
    }

    fun getProduct(productId: String) : Product? {
        viewModelScope.launch {
            productRepository.productList
                .map { list -> list.find { it.id == productId } }
                .collect { product ->
                    _singleProduct.value =
                        product

                }
        }
        return _singleProduct.value
    }
        fun getProducts(name: String, category: String = "All"): List<Product> = productRepository.getProducts(name, category)

//    fun filterProductByCategory(category: String) {
//        viewModelScope.launch {
//            productRepository.filterProductsByCategory(category).collect { filteredProducts ->
//                _products.value = filteredProducts
//            }
//        }
//    }
    fun updateFilteredProducts(query: String = currentQuery, category: String = currentCategory) {
        val filtered = productRepository.getProducts(query, category)
        _products.value = filtered
    }


    fun filterProductByCategory(category: String) {
        currentCategory = category
        updateFilteredProducts(category = category)
    }


    fun filterProductsByQuery(query: String) {
        currentQuery = query
        updateFilteredProducts(query = query)
    }
    private fun filterProducts(products: List<Product>, query: String, category: String): List<Product> {
        return products.filter { product ->
            (category == "All" || product.category.equals(category, ignoreCase = true)) &&
                    (query.isEmpty() || product.title.contains(query, ignoreCase = true))
        }
    }

    init {
        updateFilteredProducts()
    }
}

