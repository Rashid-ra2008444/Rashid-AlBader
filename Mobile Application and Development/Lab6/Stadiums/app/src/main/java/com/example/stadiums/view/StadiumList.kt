package com.example.stadiums.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stadiums.R
import com.example.stadiums.model.Stadium
import com.example.stadiums.repo.StadiumRepo
import com.example.stadiums.ui.theme.StadiumsTheme

    @Composable
    fun StadiumCard(stadium: Stadium,modifier: Modifier=Modifier)
    {       // We use this to get the image
        val imageId = LocalContext.current.resources.getIdentifier(
            stadium.imageName,
            "drawable",
            LocalContext.current.packageName
        )

    Card (
    modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.size(160.dp)

            )
            Column(

            ) {
                Text(text = "Stadium name is ${stadium.name}.")
                Text(text = "City name is ${stadium.city}.")
                Text(text = "Stadium status ${stadium.status}.")
                Text(text = "Name of the image ${stadium.imageName}.")
                Text(text = "Capacity of ${stadium.seatingCapacity.toString()}.")
            }
        }


        }
    }

@Composable
fun StadiumList(stadiums: List<Stadium>,paddingValues: PaddingValues=PaddingValues(10.dp))
{
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues()
    ){
        items(stadiums){
            StadiumCard(it)
        }
    }
}

@Composable
fun StadiumSearchBar(){



}







@Preview
@Composable
fun StadiumCardPreview()
{
    val stadium = Stadium("Al Gharafa",
       "Doha","Built","al-gharafa",1000)
    StadiumsTheme {
        StadiumCard(stadium)
    }
}

@Preview
@Composable
fun StadiumListPrivew(){
    val stadiums = StadiumRepo.getStadium(LocalContext.current)
    StadiumsTheme {
        StadiumList(stadiums)
    }
}

@Preview
@Composable
fun StadiumSearchBarPreview(){
    StadiumsTheme {
        StadiumSearchBar()
    }
}