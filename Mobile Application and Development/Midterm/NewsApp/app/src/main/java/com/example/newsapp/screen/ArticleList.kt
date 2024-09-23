package com.example.newsapp.screen

import Article
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun ArticleList(articles: List<Article>, contentPaddingValues: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = contentPaddingValues
    ) {
        items(articles) { article ->
            ArticleCard(article = article)
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    val image = LocalContext.current.resources.getIdentifier(
        article.image,
        "drawable",
        LocalContext.current.packageName
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(0.5.dp, Color.LightGray, shape = RoundedCornerShape(16.dp))
            .fillMaxSize(1F),
        colors = CardDefaults.outlinedCardColors(containerColor = Color.White)
    ){
        Column(modifier = Modifier
            .padding(16.dp)

        ){
            Image(painter = painterResource(id = image),
                contentDescription =null,
                modifier = Modifier
                    .fillMaxSize().fillMaxWidth().fillMaxHeight()
            )
            Text(text = article.title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),

            ){


                Text(text ="by:${article.author}                             ${article.date}", textAlign = TextAlign.End , fontWeight = FontWeight.Bold)
            }
        Text(text = article.article,
                style = MaterialTheme.typography.bodySmall)
        Text(text = article.category,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.End,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArticleListPreview() {
    ArticleList(articles = listOf(
        Article(
            title = "Tesla's Strong Financial Results",
            article = "Tesla has released its latest financial results, which show a significant increase in revenue and profits.",
            image = "images_5",
            category = "Business",
            author = "David Williams",
            date = "2023-10-18",

        )
    ), contentPaddingValues = PaddingValues(16.dp))
}

@Preview(showBackground = true)
@Composable
fun ArticleCardPreview() {

}
