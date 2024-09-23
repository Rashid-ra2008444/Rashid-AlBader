package com.example.quickmart.repo

import com.example.quickmart.model.CartItem
import com.example.quickmart.repo.CartRepository.cartItems


object CartRepository {

    var cartItems = mutableListOf<CartItem>()

    fun addItem(cartItem: CartItem) {

        val existingItem = cartItems.find { it.productID == cartItem.productID }

        if (existingItem != null) {

            existingItem.quantity += cartItem.quantity
            return
        } else {

            cartItems.add(cartItem)
        }
    }

    fun updateItem(productId: String, quantity: Int) {
        val existingItem = cartItems.find { it.productID == productId }
        existingItem?.let {
            it.quantity = quantity
        }
    }

    fun getCartTotal(): Double {
        return cartItems.sumOf { it.calculateTotalPrice() }
    }
    fun removeItem(productId: String) {
        cartItems.removeIf { it.productID == productId }
    }
}
