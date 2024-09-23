package com.example.quickmart.dataSource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.example.quickmart.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM CartItem WHERE userId = :userID")
    fun getCartItem(userID: String): Flow<List<CartItem>>

    @Transaction
    suspend fun upsertCartItem(cartItem: CartItem) {
        val insertResult = insertCartItem(cartItem)
        if (insertResult == -1L) {
            addQuantity(cartItem.productId, cartItem.userId, cartItem.quantity)
        }
    }
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cartItem: CartItem):Long

    @Update
    suspend fun updateCartItem(cartItem: CartItem)
//    @Upsert
//    suspend fun upsertCartItem(cartItem: CartItem)

    @Query("UPDATE CartItem SET quantity = quantity + :quantity WHERE productId = :productId AND userId = :userId")
    suspend fun addQuantity(productId: String, userId: String, quantity: Int)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem)

    @Query("SELECT SUM(quantity * (SELECT price FROM Product WHERE id = CartItem.productId)) FROM CartItem WHERE userId = :userId")
    fun getTotalCartValue(userId: String): Flow<Double>
}