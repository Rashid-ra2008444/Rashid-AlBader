package com.example.quickmart.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns =  ["categoryId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
@Serializable
data class Product(
    var title: String,
    var description: String,
    var price: Double,
    var rating: Int,
    var imageName: String,
    var categoryId: Int,

    @PrimaryKey()
    var id: String = UUID.randomUUID().toString()
){
    constructor() : this("","",0.0,0,"",0)
}
