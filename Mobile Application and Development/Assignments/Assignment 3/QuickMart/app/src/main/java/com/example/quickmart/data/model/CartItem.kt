package com.example.quickmart.data.model

import com.example.quickmart.data.repository.ProductRepository
import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    var productId: String,
    var quantity: Int
) {
    fun calculateTotalPrice(): Double {
        val productPrice = ProductRepository.getProduct(productId)?.price
        return quantity * productPrice!!
    }
}