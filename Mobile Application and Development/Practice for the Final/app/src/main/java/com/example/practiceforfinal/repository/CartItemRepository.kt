package com.example.practiceforfinal.repository

import android.app.Application
import com.example.practiceforfinal.dataSource.FruitDB
import com.example.practiceforfinal.model.CartItem
import com.example.practiceforfinal.model.Fruit
import kotlinx.coroutines.flow.Flow

class CartItemRepository(appContext : Application) {

    private val cartItemDao by lazy { FruitDB.getDatabase(appContext).cartItemDao() }
    private val fruitDao by lazy { FruitDB.getDatabase(appContext).fruitDao() }


    fun getCartItem(userId : String):Flow<List<CartItem>>{
        return cartItemDao.getCartItem(userId)
    }


    suspend fun removeCartItem(cartItem: CartItem){
        cartItemDao.deleteCartItem(cartItem)
    }

    suspend fun upsertCartItem(cartItem: CartItem){
        cartItemDao.upsertCartItem(cartItem)
    }

    suspend fun addCartItem(userId :String , fruits : List<Fruit>){
        fruits.forEach {
            upsertCartItem(CartItem(it.id , 1 , userId))
        }
    }


}