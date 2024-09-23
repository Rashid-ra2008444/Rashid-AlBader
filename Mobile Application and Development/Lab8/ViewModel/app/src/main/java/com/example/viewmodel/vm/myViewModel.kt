package com.example.viewmodel.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class myViewModel() : ViewModel(){
    var _counter = mutableStateOf(0)
        private set
    var counter : State<Int> = _counter

    fun increment() {
        _counter.value++
    }
}
