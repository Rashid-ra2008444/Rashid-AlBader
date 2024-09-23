package com.example.practiceforfinal.repository

import android.app.Application
import com.example.practiceforfinal.dataSource.FruitDB
import com.example.practiceforfinal.model.Fruit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class FruitRepository (appContext: Application) {

    private val fruitDao by lazy { FruitDB.getDatabase(appContext).fruitDao() }

    fun getAllFruits(): Flow<List<Fruit>> = fruitDao.getAllFruits()

    suspend fun getFruit(fruitId : Int) :Fruit {
        return getAllFruits().first().find { it.id == fruitId } ?: throw NoSuchElementException("Fruit Not Found")
    }

    suspend fun upsertFruit(fruit: Fruit){
        fruitDao.upsertFruit(fruit)
    }

    suspend fun deleteFruit(fruit: Fruit){
        fruitDao.deleteFruit(fruit)
    }
}