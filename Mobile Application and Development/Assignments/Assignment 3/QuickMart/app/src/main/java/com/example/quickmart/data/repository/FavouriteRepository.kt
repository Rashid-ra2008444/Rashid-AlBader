package com.example.quickmart.data.repository

import com.example.quickmart.data.model.Product

object FavouriteRepository {

    private var favouriteItems = mutableListOf<Product>()
    fun getFavourites() = favouriteItems
    fun addToFavourites(product: Product) {
        favouriteItems.add(product)
    }

}





