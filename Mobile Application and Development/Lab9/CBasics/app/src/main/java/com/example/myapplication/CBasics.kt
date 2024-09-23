package com.example.myapplication

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld()
    println("done")
}


suspend fun doWorld() = coroutineScope{
    var x = 0


    val job = launch {
        delay(1000L)
        x=10
    }

    job.join()
    println(100/x)

}