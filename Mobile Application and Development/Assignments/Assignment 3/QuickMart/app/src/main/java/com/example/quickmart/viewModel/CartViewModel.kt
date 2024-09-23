package com.example.quickmart.viewModel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.data.model.CartItem
import com.example.quickmart.data.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val cartRepository = CartRepository
    val cartItems: StateFlow<List<CartItem>> = cartRepository.cartItemsFlow.asStateFlow()
    fun getCartItems() = cartRepository.cartItemsFlow
    fun addCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.addCartItem(cartItem)
        }
    }
    fun removeCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.removeCartItem(cartItem)
        }
    }

    fun updateItem(productId: String, quantity: Int) {
        viewModelScope.launch {
            cartRepository.updateItem(productId, quantity)
        }
    }

    fun getCartItemCount(productId: String): Flow<Int> {
        return cartItems
            .map { items -> items.firstOrNull { it.productId == productId }?.quantity ?: 0 }
    }
    fun getCartTotal():Double = cartRepository.getCartTotal()
    fun clearItems() {
        viewModelScope.launch {
            cartRepository.clearCart()
        }
    }
}