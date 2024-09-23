package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

object StadiumRepo {
    var stadiums = mutableListOf<Stadium>()

    private val json = Json { ignoreUnknownKeys = true }

    fun getStadium(context: Context): List<Stadium>{
        if(stadiums.isEmpty()) {

            val jsonContext =
                context
                    .assets
                    .open("stadiums.json")
                    .bufferedReader().use { it.readText() }


            stadiums = json.decodeFromString(jsonContext)
        }
        return stadiums
    }
    fun search(searchQuery:String): List<Stadium>
         = stadiums.filter { it.name.contains(searchQuery,true) || it.city.contains(searchQuery,true) }


    fun sort(stadium: List<Stadium>,sortBy :String):List<Stadium>{
    return when(sortBy){
            "Name" -> stadium.sortedBy { it.name }
            "City" -> stadium.sortedBy { it.city }
            "Capacity" -> stadium.sortedBy { it.seatingCapacity }
            "Status" -> stadium.sortedBy { it.status }
            else -> stadium
        }
    }
}