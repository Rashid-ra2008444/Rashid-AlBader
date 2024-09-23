package com.example.quickmart.ui.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.model.User
import com.example.quickmart.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(appContext:Application) : AndroidViewModel(appContext) {

    private val userRepository by lazy { UserRepository(appContext) }

    private val _userId = MutableStateFlow<String>("")
    val userId: StateFlow<String> = _userId
    fun insertUser(user: User){
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    init {
        viewModelScope.launch {
            val user = userRepository.getOrCreateUser()
            _userId.value = user.id
        }
    }



}