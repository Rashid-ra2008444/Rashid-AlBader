package com.example.quickmart.repository

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.example.quickmart.dataSource.local.QuickMartDB
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach

class CartRepository (appContext : Application) {

    private val cartDao by lazy {QuickMartDB.getDatabase(appContext).cartDao()}
    private val userDao by lazy {QuickMartDB.getDatabase(appContext).userDao()}


    // Get all cart items for a specific user
    fun getCartItems(userId: String): Flow<List<CartItem>> {
       return cartDao.getCartItem(userId).onEach { items ->
           Log.d("CartRepo", "Cart items loaded: $items")
       }
    }

    // Remove a cart item from the database
    suspend fun removeCartItem(cartItem: CartItem) {
        cartDao.deleteCartItem(cartItem)
    }

    // Insert or update a cart item in the database
    suspend fun upsertCartItem(cartItem: CartItem) {
        cartDao.upsertCartItem(cartItem)
    }

    // Calculate the total price of the cart
    fun getCartTotal(userId: String): Flow<Double> = cartDao.getTotalCartValue(userId)

    // Add multiple cart items to the database for a specific user
    suspend fun addCartItems(userId: String, products: List<Product>) {
        products.forEach {
            upsertCartItem(CartItem(it.id, 1, userId))
        }
    }

    // You may no longer need the clearItems method if you are using a database.
    // However, if you want to clear all cart items for a specific user, you can implement it like this:
    suspend fun clearItems(userId: String) {
        val items = cartDao.getCartItem(userId).first() // Use first() to get the current list once
        items.forEach { removeCartItem(it) }
    }
}