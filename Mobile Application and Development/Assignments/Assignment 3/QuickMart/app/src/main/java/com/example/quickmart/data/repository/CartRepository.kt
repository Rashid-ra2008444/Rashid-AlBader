package com.example.quickmart.data.repository

import com.example.quickmart.data.model.CartItem
import kotlinx.coroutines.flow.MutableStateFlow

object CartRepository {
    private val _cartItemsFlow = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItemsFlow: MutableStateFlow<List<CartItem>> get() = _cartItemsFlow

    fun addCartItem(cartItem: CartItem) {
        // Convert the current cart items to a mutable list to allow modification.
        val cart = _cartItemsFlow.value.toMutableList()

        // Find the index of the existing item with the same product ID.
        val existingItemIndex = cart.indexOfFirst { it.productId == cartItem.productId }

        if (existingItemIndex >= 0) {
            // If the item exists, increment its quantity.
            val existingItem = cart[existingItemIndex]
            val newQuantity = existingItem.quantity + cartItem.quantity
            cart[existingItemIndex] = existingItem.copy(quantity = newQuantity)
        } else {
            // If the item does not exist, add the new item to the cart.
            cart.add(cartItem)
        }

        // Update the _cartItemsFlow to reflect the changes.
        _cartItemsFlow.value = cart
    }
    fun clearCart() {
        _cartItemsFlow.value = emptyList()
    }
    fun removeCartItem(cartItem: CartItem) {

        _cartItemsFlow.value = _cartItemsFlow.value - cartItem
    }

    fun updateItem(productId: String, quantity: Int) {

        val cart = _cartItemsFlow.value.toMutableList()
        val itemIndex = cart.indexOfFirst { it.productId == productId }
        if (itemIndex != -1) {
            val existingItem = cart[itemIndex]
            val newQuantity = existingItem.quantity + quantity
            if (newQuantity > 0) {
                cart[itemIndex] = existingItem.copy(quantity = newQuantity)
            } else {
                cart.removeAt(itemIndex)
            }
        } else if (quantity > 0) {
            cart.add(CartItem(productId, quantity))
        }
        _cartItemsFlow.value = cart
    }

    fun getCartTotal(): Double {
        return _cartItemsFlow.value.fold(0.0) { acc, cartItem ->
            acc + cartItem.calculateTotalPrice()
        }
    }
}