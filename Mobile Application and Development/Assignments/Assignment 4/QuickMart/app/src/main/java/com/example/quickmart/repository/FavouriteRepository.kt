package com.example.quickmart.repository

import android.app.Application
import com.example.quickmart.dataSource.local.QuickMartDB
import com.example.quickmart.model.Favourite
import com.example.quickmart.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach

class FavouriteRepository (appContext : Application) {
    private val favouriteDao by lazy { QuickMartDB.getDatabase(appContext).favouriteDao() }
    private var favouriteItemsInMemory : MutableList<Favourite> = mutableListOf()

    fun getFavouriteItem(userId: String): Flow<List<Favourite>> = favouriteDao.getFavourite(userId)
        .onEach { favourites ->
            // Sync the in-memory list with the latest data from the database
            favouriteItemsInMemory.clear()
            favouriteItemsInMemory.addAll(favourites)
        }

    suspend fun addFavouriteItem(favItem: Favourite) {
        if (!isFavourite(favItem.productId, favItem.userId)) {
            favouriteDao.addFavourite(favItem)
            // Keep the in-memory list in sync
            favouriteItemsInMemory.add(favItem)
        }
    }

    suspend fun removeFavouriteItem(favItem: Favourite) {
        favouriteDao.removeFavourite(favItem)
        // Keep the in-memory list in sync
        favouriteItemsInMemory.remove(favItem)
    }

      fun isInFavourite(userId: String, productId : String): Boolean {
        return favouriteItemsInMemory.any() {it.userId == userId && it.productId == productId}
    }

    suspend fun clearItems(userId: String) {
        favouriteDao.clearFavourites(userId)
        favouriteItemsInMemory.clear() // Clear the in-memory list
    }

    suspend fun isFavourite(productId: String, userId: String): Boolean {
        return favouriteDao.isFavourite(productId, userId)
    }

    suspend fun toggleFavourite(product: Product, userId: String) {
        val favItem = Favourite(product.id, userId)
        if (isFavourite(product.id, userId)) {
            removeFavouriteItem(favItem)
        } else {
            addFavouriteItem(favItem)
        }
    }

}



//    private var favourites = mutableListOf<Favourite>();
//    fun clearItems() = favourites.clear()
//    fun getFavouriteItems(): List<Favourite> = favourites
//    fun addToFavourites(favItem: Favourite) {
//        val item = favourites.find { it.productId == favItem.productId }
//        if (item == null) favourites.add(favItem)
//    }
//
//    fun removeFromFavourites(productId: String) {
//        favourites = favourites.filter { it.productId != productId }.toMutableList()
//    }
//
//    fun isInFavourite(id: String): Boolean = favourites.find { it.productId == id } != null
//}