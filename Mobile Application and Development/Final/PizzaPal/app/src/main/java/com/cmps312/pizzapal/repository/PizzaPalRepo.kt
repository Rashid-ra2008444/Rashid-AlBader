package com.cmps312.pizzapal.repository

import android.content.Context
import com.cmps312.pizzapal.datasource.PizzaPalDatabase
import com.cmps312.pizzapal.entity.Order
import com.cmps312.pizzapal.entity.Pizza


class PizzaPalRepo(appContext: Context) {
//    add the Room annotations
    private val pizzaPalDao by lazy { PizzaPalDatabase.getDatabase(appContext).pizzaPalDao()}


    fun getAllPizzas() = pizzaPalDao.getAllPizzas()

    fun getPizzasByOrderId(orderId: Int) = pizzaPalDao.getPizzasByOrderId(orderId)

    suspend fun upsertPizza(pizza: Pizza) = pizzaPalDao.upsertPizza(pizza)

    suspend fun deletePizza(pizza: Pizza) = pizzaPalDao.deletePizza(pizza)

    suspend fun upsertOrder(order: Order) = pizzaPalDao.upsertOrder(order)

    fun getAllOrders() = pizzaPalDao.getAllOrders()

    suspend fun deleteOrder(order: Order) = pizzaPalDao.deleteOrder(order)
}