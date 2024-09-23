package com.cmps312.pizzapal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cmps312.pizzapal.entity.Order
import com.cmps312.pizzapal.entity.Pizza
import com.cmps312.pizzapal.repository.PizzaPalRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PizzaPalViewModel(appContext: Application) : AndroidViewModel(appContext) {
    private val pizzaPalRepo by lazy { PizzaPalRepo(appContext) }

    private val _pizzas = MutableStateFlow<List<Pizza>>(emptyList())
    val pizzas : StateFlow<List<Pizza>> = _pizzas

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders : StateFlow<List<Order>> = _orders

    fun getAllPizzas() {
        viewModelScope.launch {
            pizzaPalRepo.getAllPizzas().collect {
                pizzas ->
                _pizzas.value = pizzas

            }
        }
    }

    fun getPizzasByOrderId(orderId: Int) {
        viewModelScope.launch {
            pizzaPalRepo.getPizzasByOrderId(orderId)
        }
    }

    fun upsertPizza(pizza: Pizza) {
        viewModelScope.launch {
            pizzaPalRepo.upsertPizza(pizza)

        }
    }

    fun deletePizza(pizza: Pizza) {
        viewModelScope.launch {
            pizzaPalRepo.deletePizza(pizza)
        }
    }

    fun upsertOrder(order: Order) {
        viewModelScope.launch {
            pizzaPalRepo.upsertOrder(order)
        }
    }

    fun getAllOrders() {
        viewModelScope.launch {
            pizzaPalRepo.getAllOrders()
        }
    }

    fun deleteOrder(order: Order) {
        viewModelScope.launch {
            pizzaPalRepo.deleteOrder(order)
        }
    }

}