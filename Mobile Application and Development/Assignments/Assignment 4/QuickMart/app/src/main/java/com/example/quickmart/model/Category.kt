package com.example.quickmart.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID

@Entity(indices = [Index(value = ["category"], unique = true)])
@Serializable
class Category(
    val category: String,
    @PrimaryKey
    val id: Int = 0
)

