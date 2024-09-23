package com.example.practiceforfinal.model

import androidx.room.Entity
import androidx.room.ForeignKey
import kotlinx.serialization.Serializable
@Entity(
    primaryKeys = ["fruitId","userId"],
    foreignKeys = [
        ForeignKey(
            entity = Fruit::class,
            parentColumns = ["id"],
            childColumns =  ["fruitId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
@Serializable
data class CartItem(
    var fruitId : Int,
    var quantity : Int,
    var userId : String

){
    constructor() : this(0,0,"")
}