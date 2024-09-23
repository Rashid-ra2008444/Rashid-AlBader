package com.example.quickmart.dataSource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quickmart.model.Favourite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Query("SELECT * FROM Favourite WHERE userId = :userId")
    fun getFavourite(userId: String): Flow<List<Favourite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourite(favourite: Favourite)

    @Delete
    suspend fun removeFavourite(favourite : Favourite)

    @Query("DELETE FROM Favourite WHERE userId = :userID")
    suspend fun clearFavourites(userID: String)

    @Query("SELECT EXISTS(SELECT 1 FROM Favourite WHERE productId = :productId AND userId = :userId)")
    suspend fun isFavourite(productId: String, userId: String): Boolean
}