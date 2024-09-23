package com.example.practiceforfinal.ui.cartItem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceforfinal.model.CartItem
import com.example.practiceforfinal.repository.CartItemRepository
import com.example.practiceforfinal.repository.FruitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class CartViewModel (appContext : Application) : AndroidViewModel(appContext) {

    private val cartItemRepository by lazy { CartItemRepository(appContext) }
    private val fruitRepository by lazy { FruitRepository(appContext) }

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItem : StateFlow<List<CartItem>> = _cartItems

    private fun loadCartItem(userId:String) {
    viewModelScope.launch {
        cartItemRepository.getCartItem(userId).collect { items ->
            _cartItems.value = items
            }
        }
    }

    fun initCart(userId : String) {
        loadCartItem(userId)
    }

    fun upsertCartItem(fruitId:Int , quantity : Int, userId : String) {
        viewModelScope.launch {
            cartItemRepository.upsertCartItem(CartItem(fruitId,quantity, userId))
            _cartItems.value = cartItemRepository.getCartItem(userId).first()
        }
    }

    fun removeCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartItemRepository.removeCartItem(cartItem)
        }
    }


}