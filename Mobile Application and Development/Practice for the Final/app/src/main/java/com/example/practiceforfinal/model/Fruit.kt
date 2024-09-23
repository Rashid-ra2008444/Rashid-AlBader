package com.example.practiceforfinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Fruit(
    val name :String,
    val color : String,
    @PrimaryKey
    val id :Int = 0
){
    constructor() : this ("","")
}

