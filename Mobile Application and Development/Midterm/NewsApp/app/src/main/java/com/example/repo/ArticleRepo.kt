package com.example.Articles.repo

import Article
import android.content.Context
import kotlinx.serialization.json.Json

object CategoryOptions {
    const val None = "ALL"
    const val POLITICS = "Politics"
    const val BUSINESS = "Business"
    const val TECHNOLOGY = "Technology"
}
private val json = Json { ignoreUnknownKeys = true }
object ArticleRepo {
    private var articles = mutableListOf<Article>()
    fun getArticles(context: Context): List<Article> {
        if (articles.isEmpty()) {
            val jsonContext =
                context
                    .assets
                    .open("articles.json")
                    .bufferedReader().use { it.readText() }
            articles = json.decodeFromString(jsonContext)
        }
        return articles
    }

    fun filterArticles(filter: String): List<Article>
    = articles.filter {it.article.contains(filter,true)  || it.category.contains(filter,true) }



}