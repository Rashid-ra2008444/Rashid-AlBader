package com.example.quickmart.dataSource.local

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quickmart.model.CartItem
import com.example.quickmart.model.Category
import com.example.quickmart.model.Favourite
import com.example.quickmart.model.Product
import com.example.quickmart.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


@Database(entities = [Product::class , Favourite::class, CartItem::class , User::class , Category::class] , version = 13 , exportSchema = false)
abstract class QuickMartDB : RoomDatabase() {

    abstract fun productDao() : ProductDao

    abstract fun cartDao() : CartDao

    abstract fun userDao() : UserDao

    abstract fun favouriteDao() : FavouriteDao

    abstract fun categoryDao() : CategoryDao

    companion object {
        private var database: QuickMartDB? = null

        fun getDatabase(context: Context): QuickMartDB {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    QuickMartDB::class.java,
                    "QuickMartDB"
                )
                    .addCallback(DatabaseCallback(context))
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return database as QuickMartDB
        }

        fun initializeData(context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                val db = getDatabase(context)
                populateDatabase(db, context)
            }
        }

        private class DatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(getDatabase(context), context)
                }
            }
        }

        suspend fun populateDatabase(db: QuickMartDB, context: Context) {
            val categories = initCategory(context)
            db.categoryDao().apply {
                categories.forEach { insertOrUpdateCategory(it) }
            }

            val products = initProduct(context)
            db.productDao().apply {
                products.forEach { upsertProduct(it) }
            }


        }

        private fun initProduct(context: Context): List<Product> {
            val jsonString =
                context.assets.open("products.json").bufferedReader().use { it.readText() }
            return Json.decodeFromString<List<Product>>(jsonString)
        }

        private fun initCategory(context: Context): List<Category> {
            val jsonString = context.assets.open("categories.json").bufferedReader().use { it.readText() }
            return Json.decodeFromString(jsonString)
        }

    }

}