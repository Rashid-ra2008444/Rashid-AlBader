package com.example.quickmart.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID


@Entity
@Serializable
data class User (
    var firstName: String,
    var lastName: String,
    var email: String,
    var password: String,
    var isAdmin: Boolean,
    var profilePic: String,

   @PrimaryKey()
    var id: String = UUID.randomUUID().toString()

) {
    constructor(): this("","","","",false,"")
}