package com.example.quickmart.repo

import android.content.Context
import com.example.quickmart.model.Product
import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

object ProductRepository {
    var productList = mutableListOf<Product>()
    fun initProduct(context : Context) : List<Product>{
        if(productList.isEmpty()) {


        val jsonContext =
            context
                .assets
                .open("products.json")
                .bufferedReader().use { it.readText() }
        productList = json.decodeFromString(jsonContext)
        }
        return productList
    }
    fun getProduct(name:String,category:String="All"): List<Product>{
        return productList.filter { product -> product.title.contains(name,ignoreCase = true)&&
                (category=="All"||product.category.equals(category,ignoreCase = true)) }
    }

    var categoryList = mutableListOf<String>()

    fun getCategory(context : Context):List<String>{

        if(categoryList.isEmpty()) {


            val jsonContext =
                context
                    .assets
                    .open("product-categories.json")
                    .bufferedReader().use { it.readText() }
            categoryList = json.decodeFromString(jsonContext)
        }
        return categoryList
    }

    fun search(searchQuery:String): List<Product>
            = productList.filter { it.title.contains(searchQuery,true) || it.category.contains(searchQuery,true) }


//    fun sort(stadium: List<Stadium>,sortBy :String):List<Stadium>{
//        return when(sortBy){
//            "Name" -> stadium.sortedBy { it.name }
//            "City" -> stadium.sortedBy { it.city }
//            "Capacity" -> stadium.sortedBy { it.seatingCapacity }
//            "Status" -> stadium.sortedBy { it.status }
//            else -> stadium
//        }
//    }


}

