package com.example.quickmart.model

import kotlinx.serialization.Serializable


@Serializable
data class CartItem
    (
    val productID : String,
    val productName : String,
    var quantity : Int,
    val unitPrice : Double
            ) {

        fun calculateTotalPrice() : Double {

            return quantity * unitPrice
        }
}