package com.example.newsapp.screen

import Article
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewsInfoForm(
    onAddNewsInfo: (Article) -> Unit
) {
   var title by remember { mutableStateOf("") }
    var article by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }

    Card(modifier = Modifier.fillMaxSize()){
        Text(text = "Add News Info",
            modifier = Modifier.align(CenterHorizontally),
            style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
            TextField(
                value = article,
                onValueChange = { article = it },
                label = { Text("Article") })
            TextField(value = image, onValueChange = { image = it }, label = { Text("Image") })
            TextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") })
            TextField(
                value = authorName,
                onValueChange = { authorName = it },
                label = { Text("Author Name") })
            TextField(value = date, onValueChange = { date = it }, label = { Text("Date") })
        }

        Button(
            onClick={
                onAddNewsInfo(
                    Article(title,
                        article,
                        image,
                        category,
                        date,
                        authorName
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Article")
        }


    }

}



