package com.example.quickmart.ui.details

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Favourite
import com.example.quickmart.model.Product
import com.example.quickmart.repository.CartRepository
import com.example.quickmart.repository.FavouriteRepository
import com.example.quickmart.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(appContext : Application) : AndroidViewModel(appContext) {

    private val cartRepository by lazy {CartRepository(appContext)}
    private val productRepository by lazy {ProductRepository(appContext)}
    private val favouriteRepository by lazy { FavouriteRepository(appContext) }

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product.asStateFlow()

    var quantity by mutableIntStateOf(1)

    private var _total = MutableStateFlow(0.0)
    var total : StateFlow<Double> = _total.asStateFlow()

    private val _isFavourite = MutableStateFlow(false)
    val isFavourite: StateFlow<Boolean> = _isFavourite.asStateFlow()


    fun loadProductDetails(productId: String){
        viewModelScope.launch {
            val product = productRepository.getProduct(productId)
            _product.value = product
            _total.value = product.price.times(quantity)
        }
    }

    fun updateQuantity(change: Int) {
        val newQuantity = (quantity + change).coerceAtLeast(1)
        quantity = newQuantity
        _product.value?.let {
            _total.value = it.price * newQuantity
        }
    }

    fun addToCart(productId: String , userId :String) {
        viewModelScope.launch {
            _product.value?.let {
                cartRepository.upsertCartItem(CartItem(productId, quantity , userId))
                quantity = 1
                _total.value = it.price * quantity
            }
        }
    }

    fun checkIfProductIsFavourite(productId: String? , userId: String) {
        viewModelScope.launch {
            if (productId != null) {
                _isFavourite.value = favouriteRepository.isInFavourite(userId, productId)
            }
        }
    }
}