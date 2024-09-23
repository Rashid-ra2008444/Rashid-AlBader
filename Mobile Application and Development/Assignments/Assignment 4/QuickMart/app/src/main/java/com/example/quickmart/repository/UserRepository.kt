package com.example.quickmart.repository

import android.app.Application
import com.example.quickmart.dataSource.local.QuickMartDB
import com.example.quickmart.dataSource.local.UserDao
import com.example.quickmart.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(appContext : Application) : UserDao {

    private val userDao by lazy { QuickMartDB.getDatabase(appContext).userDao() }
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    override fun getUserById(userId: String): Flow<User> {
        return userDao.getUserById(userId)
    }

    suspend fun getOrCreateUser(): User {

        val newUser = User("Rashid","Al-bader","RA2020@gmail.com","RA113322",true,"")
        insertUser(newUser)
        return newUser
    }
}