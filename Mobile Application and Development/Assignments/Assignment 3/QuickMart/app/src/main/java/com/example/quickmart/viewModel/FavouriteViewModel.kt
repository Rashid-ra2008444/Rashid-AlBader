package com.example.quickmart.viewModel

import androidx.lifecycle.ViewModel
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.FavouriteRepository

class FavouriteViewModel : ViewModel() {
    private val favouriteRepository = FavouriteRepository

    fun getFavourite() = favouriteRepository.getFavourites()
    
    fun addToFavourites(product: Product) = favouriteRepository.addToFavourites(product)
}