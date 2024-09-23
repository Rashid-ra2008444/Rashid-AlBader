package com.example.quickmart.ui.product

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.model.Category
import com.example.quickmart.model.Product
import com.example.quickmart.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProductViewModel(appContext : Application) : AndroidViewModel(appContext) {

    private val productRepository by lazy {ProductRepository(appContext)}

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products : StateFlow<List<Product>> = _products.asStateFlow()

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories:StateFlow<List<Category>> = _categories.asStateFlow()

    private val _cartProducts = MutableStateFlow<List<Product>>(emptyList())
    val cartProducts: StateFlow<List<Product>> = _cartProducts.asStateFlow()


    var query by mutableStateOf("")
        private set

    private var filter by mutableStateOf(Category("All" , 0))

    lateinit var selectedProduct : Product

    init {
        viewModelScope.launch { productRepository.getAllCategory().collect {
            _categories.value = it
            Log.d("testCategory", "this is Category ->"+it.size.toString())
        } }
        viewModelScope.launch {
            productRepository.getAllProduct().collect {
                _products.value = it
                Log.d("testProduct", "this is product ->"+it.size.toString())
            }

           // _categories.value = productRepository.getAllCategory().first()

        }
    }

    fun updateList(query: String = this.query, categoryId: Int = this.filter.id) {
        this.query = query
        viewModelScope.launch {
            val allProducts = productRepository.getAllProduct().first()
            val filteredProducts = if (categoryId == 0) {
                allProducts // If categoryId is 0 (which represents "All"), use all products
            } else {
                productRepository.getProductByCategory(categoryId).first()
            }
            _products.value = filteredProducts.filter {
                it.title.contains(query, ignoreCase = true)
            }
        }
    }

    fun getMatchingProducts(productIds : List<String> ) {
         viewModelScope.launch {
            val products = productRepository.getMatchingProducts(productIds)
             Log.d("ProductViewModel", "Matching products: $products")
             _cartProducts.value = products
        }
    }

    suspend fun updateProductRating(productId:String, rating :Int) {
        productRepository.updateProductRating(productId, rating)
    }

     fun selectProduct(productId: String) {
         viewModelScope.launch {
             selectedProduct = productRepository.getProduct(productId)
         }
    }

    fun getCategoryByID(categoryId: Int) : Category? {
        return _categories.value.firstOrNull {it.id == categoryId}
    }

}

//      private val _products = MutableStateFlow(ProductRepository.productList)
//    val products = _products.asStateFlow()
//
//    var query by mutableStateOf("")
//        private set
//    private var filter by mutableStateOf(Category("All", 0))
//    lateinit var categories: List<Category>
//        private set
//
//    lateinit var selectedProduct: Product
//
//    fun updateList(query: String = this.query, filter: Category = this.filter) {
//        this.query = query
//        this.filter = filter
//        _products.value = ProductRepository.getProducts(query, filter)
//    }
//
//    fun getCategories(context: Context): List<Category> {
//        categories = ProductRepository.initCategories(context)
//        return categories
//    }
//
//    fun getCategoryName(catId: Int) = categories.first { it.id == catId }.category
//
//    fun getMatchingProducts(cartItems: State<List<CartItem>>) =
//        ProductRepository.getMatchingProducts(cartItems.value.map { it.productId })