package com.example.practiceforfinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID

@Entity
@Serializable
data class User(
    val firstName : String,
    val lastName : String,
    val phoneNum : Int,
    val bod : String,
    val workAt: String,

    @PrimaryKey()
    val id : String = UUID.randomUUID().toString()

){
    constructor() : this("","",0,"","")
}
