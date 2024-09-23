package com.example.quickmart.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val rating: Int,
    val imageName: String
)