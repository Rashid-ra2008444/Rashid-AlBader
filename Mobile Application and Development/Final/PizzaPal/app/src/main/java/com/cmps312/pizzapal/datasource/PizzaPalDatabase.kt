package com.cmps312.pizzapal.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cmps312.pizzapal.entity.Order
import com.cmps312.pizzapal.entity.Pizza

@Database(entities = [Pizza::class, Order::class], version = 4 , exportSchema = false)
abstract class PizzaPalDatabase : RoomDatabase() {
    abstract fun pizzaPalDao(): PizzaPalDao




    companion object {
        private var database : PizzaPalDatabase? = null

        fun getDatabase(context: Context) : PizzaPalDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    PizzaPalDatabase::class.java,
                    "PizzaPalDB"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as PizzaPalDatabase
        }
    }
}