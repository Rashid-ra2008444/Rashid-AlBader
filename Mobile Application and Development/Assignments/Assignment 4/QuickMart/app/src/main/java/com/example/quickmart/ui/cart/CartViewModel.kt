package com.example.quickmart.ui.cart

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Product
import com.example.quickmart.repository.CartRepository
import com.example.quickmart.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class CartViewModel (appContext : Application) : AndroidViewModel(appContext) {

    private val cartRepository by lazy {CartRepository(appContext)}
    private val productRepository by lazy { ProductRepository(appContext) }

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    private val _total = MutableStateFlow<Double>(0.0)
    val total : StateFlow<Double> = _total

//    private fun loadCartItems(userId :String) {
//        viewModelScope.launch {
//            cartRepository.getCartItems(userId).collect {
//                items ->
//                Log.d("Loading","This is the size ->"+items.size)
//                _cartItems.value = items
//
//            }
//        }
//    }

    private fun loadCartItems(userId: String) {
        viewModelScope.launch {
            cartRepository.getCartItems(userId).collect { items ->
                _cartItems.value = items
                calculateCartTotal(userId) // Recalculate the total whenever cart items change
            }
        }
    }

    fun initCart(userId: String) {
        Log.d("CartViewModel", "Initializing cart for user: $userId")
        loadCartItems(userId)
    }
    fun addOrUpdate(productId: String, quantity: Int, userId: String) {
        viewModelScope.launch {
            cartRepository.upsertCartItem(CartItem(productId, quantity, userId))
            _cartItems.value = cartRepository.getCartItems(userId).first()
            Log.d("Loading","This is the size ->"+_cartItems.value.size)
        }

    }

        fun removeCartItem(item: CartItem) {
            viewModelScope.launch {
                cartRepository.removeCartItem(item)
                calculateCartTotal(item.userId)
            }
    }

    private fun calculateCartTotal(userId: String){
        viewModelScope.launch {
            cartRepository.getCartTotal(userId).collect() {
                total ->
                _total.value = total
            }
        }
    }

        fun clearCart(userId: String) {
            viewModelScope.launch {
                cartRepository.clearItems(userId)
                loadCartItems(userId)
                _total.value = 0.0
            }
    }

    fun getQuantity(productId: String): Int {

        return _cartItems.value.firstOrNull { it.productId == productId }?.quantity ?: 0
    }

    suspend fun calculateTotalPriceForCartItem(cartItem: CartItem): Double {
        val product = productRepository.getProduct(cartItem.productId)
        return cartItem.quantity * product.price
    }



}

//    suspend fun getQuantity(product: Product) =
//        _cartItems.firstOrNull { it.productId == product.id }?.quantity

//

//
//        private fun refresh() {
//        _cartItems.value.clear()
//        _cartItems.addAll(CartRepository.getCartItems())
//        _total.value = CartRepository.getCartTotal()
//    }
//

//
//}