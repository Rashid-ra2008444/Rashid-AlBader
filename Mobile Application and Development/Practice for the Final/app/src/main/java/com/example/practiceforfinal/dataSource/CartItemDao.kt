package com.example.practiceforfinal.dataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.practiceforfinal.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItem):Long

    @Query("SELECT * FROM CartItem WHERE userId = :userID")
    fun getCartItem(userID : String) : Flow<List<CartItem>>

    @Upsert
    suspend fun upsertCartItem(cartItem: CartItem)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)

//    @Query("UPDATE cartitem SET quantity = quantity + :quantity WHERE fruitId = :fruitID AND userId = :userID")
//    suspend fun addQuantity(fruitID : String , userID: String , quantity : Int)

}