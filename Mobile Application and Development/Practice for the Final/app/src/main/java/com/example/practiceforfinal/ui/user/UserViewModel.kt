package com.example.practiceforfinal.ui.user

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceforfinal.model.User
import com.example.practiceforfinal.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel (appContext : Application) : AndroidViewModel(appContext) {

    private val userRepository by lazy { UserRepository(appContext) }

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users : StateFlow<List<User>> = _users

    init {
        loadAllUsers()
    }

    fun insertUser(user: User){
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    private fun loadAllUsers() {
        viewModelScope.launch {
            userRepository.getAllUsers().collect {userList ->
                _users.value = userList
            }
        }
    }

    fun getUserById(userId : String) {
        viewModelScope.launch {
            userRepository.getUserById(userId)
        }
    }

}