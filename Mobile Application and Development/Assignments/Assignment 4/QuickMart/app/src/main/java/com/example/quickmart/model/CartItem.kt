package com.example.quickmart.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.quickmart.repository.ProductRepository
import kotlinx.serialization.Serializable
import java.util.UUID


@Entity(
    primaryKeys = ["productId", "userId"],
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)

@Serializable
data class CartItem(
    var productId: String,
    var quantity:  Int,
    var userId: String,

//    @PrimaryKey
//    var id: String = UUID.randomUUID().toString(),


) {
    constructor() : this("",0,"")
}