package com.example.quickmart.ui.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.model.Favourite
import com.example.quickmart.model.Product
import com.example.quickmart.repository.CartRepository
import com.example.quickmart.repository.FavouriteRepository
import com.example.quickmart.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FavouriteViewModel(appContext : Application) : AndroidViewModel(appContext) {

    private val favouriteRepository by lazy { FavouriteRepository(appContext) }
    private val cartRepository by lazy {CartRepository(appContext)}
    private val productRepository by lazy {ProductRepository(appContext)}

    private var _favourites = MutableStateFlow<List<Favourite>>(emptyList())
    val favourites: StateFlow<List<Favourite>> = _favourites

    private val _isFavouriteMap = MutableStateFlow<Map<String,Boolean>>(emptyMap())
    val isFavouriteMap : StateFlow<Map<String,Boolean>> = _isFavouriteMap.asStateFlow()

    private val _matchingProducts = MutableStateFlow<List<Product>>(emptyList())
    val matchingProducts: StateFlow<List<Product>> = _matchingProducts.asStateFlow()


    init {
        viewModelScope.launch {
            favouriteRepository.getFavouriteItem(Favourite().id).collect() {favs ->
                _favourites.value = favs
                updateMatchingProducts()
            }
        }
    }

    init {
        viewModelScope.launch {
            // Load initial favourite products for the user
            loadFavouriteProducts(Favourite().userId)
        }
    }

    private fun loadFavouriteProducts(userId: String) {
        viewModelScope.launch {
            val favouritesList = favouriteRepository.getFavouriteItem(userId).first()
            _favourites.value = favouritesList
            val productIds = favouritesList.map { it.productId }
            val products = productRepository.getMatchingProducts(productIds)
            _matchingProducts.value = products
        }
    }

    private suspend fun updateMatchingProducts() {
        val productIds = _favourites.value.map { it.productId }
        val products = productRepository.getMatchingProducts(productIds)
        _matchingProducts.value = products
    }

    fun onRemoveProductFromFavourite(productId: String, userId: String) {
        viewModelScope.launch {
            favouriteRepository.removeFavouriteItem(Favourite(productId, userId))
            updateMatchingProducts()
        }
    }

    fun addAllFavToCart(userId: String) {
        viewModelScope.launch {
            val productIds = _favourites.value.map { it.productId }
            val products = productRepository.getMatchingProducts(productIds)
            cartRepository.addCartItems(userId, products)
            favouriteRepository.clearItems(userId)
            updateMatchingProducts()
        }
    }

    fun addToFavourite(productId: String, userId: String) {
        viewModelScope.launch {
            favouriteRepository.addFavouriteItem(Favourite(productId, userId))
            updateMatchingProducts()
        }
    }

    fun isInFavourite(userId: String, productId: String): Boolean {
        return favouriteRepository.isInFavourite(userId, productId)
    }

    fun getMatchingProducts(productIds: List<String?>) {
        viewModelScope.launch {
            val products = productRepository.getMatchingProducts(productIds)
            _matchingProducts.value = products
        }
    }

    fun toggleFavourite(productId: String, userId: String) {
        viewModelScope.launch {
            val isCurrentlyFavourite = favouriteRepository.isFavourite(productId, userId)
            if (isCurrentlyFavourite) {
                favouriteRepository.removeFavouriteItem(Favourite(productId, userId))
            } else {
                favouriteRepository.addFavouriteItem(Favourite(productId, userId))
            }
            // Update the state to reflect the change
            _isFavouriteMap.value = _isFavouriteMap.value.toMutableMap().apply {
                put(productId, !isCurrentlyFavourite)
            }
            updateFavouriteProducts(userId)
        }
    }
    private fun updateFavouriteProducts(userId: String) {
        loadFavouriteProducts(userId)
    }

}


//    fun onRemoveProductFromFavourite(product: Product) {
//        FavouriteRepository.removeFromFavourites(product.id)
//        refresh()
//    }
//
//    fun addAllFavToCart(userId : String) {
//        viewModelScope.launch() {
//            val productIds = FavouriteRepository.getFavouriteItems().map { it.productId }
//            val products = ProductRepository.getMatchingProducts(productIds)
//            cartRepository.addCartItems(userId , products)
//            FavouriteRepository.clearItems()
//            refresh()
//        }
//    }
//
//    fun addToFavourite(product: Product) {
//        FavouriteRepository.addToFavourites(Favourite(product.id))
//        refresh()
//    }
//
//    fun isInFavourite(product: Product): Boolean = FavouriteRepository.isInFavourite(product.id)
//
//    fun getMatchingProducts(): List<Product> =
//        ProductRepository.getMatchingProducts(favourites.map { it.productId })
//
//    private fun refresh() {
//        _favourites.clear()
//        _favourites.addAll(FavouriteRepository.getFavouriteItems())
//    }