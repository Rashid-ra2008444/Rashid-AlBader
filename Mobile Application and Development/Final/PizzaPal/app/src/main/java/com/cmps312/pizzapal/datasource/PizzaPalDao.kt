package com.cmps312.pizzapal.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.cmps312.pizzapal.entity.Order
import com.cmps312.pizzapal.entity.Pizza
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaPalDao {
    @Query("SELECT * FROM Pizza")
    fun getAllPizzas(): Flow<List<Pizza>>

    @Query("SELECT * FROM Pizza WHERE orderId = :orderId")
    fun getPizzasByOrderId(orderId: Int): Flow<List<Pizza>>

    @Upsert
    suspend fun upsertPizza(pizza: Pizza)

    @Delete
    suspend fun deletePizza(pizza: Pizza)

    @Upsert
    suspend fun upsertOrder(order: Order)

    @Query("SELECT * FROM `Order`")
    fun getAllOrders(): List<Order>

    @Delete
    suspend fun deleteOrder(order: Order)




}