package com.example.practiceforfinal.repository

import android.app.Application
import com.example.practiceforfinal.dataSource.FruitDB
import com.example.practiceforfinal.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository (appContext :Application){
    private val userDao by lazy { FruitDB.getDatabase(appContext).userDao() }

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    fun getUserById(userId : String) : Flow<User>{
        return userDao.getUserById(userId)
    }


    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }



}