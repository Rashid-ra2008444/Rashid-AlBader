package com.example.practiceforfinal.dataSource

import android.content.Context
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practiceforfinal.model.CartItem
import com.example.practiceforfinal.model.Fruit
import com.example.practiceforfinal.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


@Database(entities = [CartItem::class , Fruit::class , User::class], version = 1 , exportSchema = false)
abstract class FruitDB : RoomDatabase() {


    abstract fun cartItemDao() : CartItemDao

    abstract fun userDao() : UserDao

    abstract  fun fruitDao() : FruitDao

    companion object {
        private var database : FruitDB? = null

        fun getDatabase(context:Context) : FruitDB {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    FruitDB::class.java,
                    "FruitDB"
                ).addCallback(DatabaseCallBack(context))
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return  database as FruitDB
        }

        private fun initFruit(context : Context) :List<Fruit>{
            val jsonString =
                context.assets.open("fruit.json").bufferedReader().use { it.readText() }
            return Json.decodeFromString(jsonString)
        }

        suspend fun populateDatabase(db :FruitDB , context: Context){
            val fruits = initFruit(context)
            db.fruitDao().apply {
                fruits.forEach { upsertFruit(it)}
            }
        }

        private class DatabaseCallBack(private val context : Context): RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(getDatabase(context),context)
                }
            }
        }

    }

}