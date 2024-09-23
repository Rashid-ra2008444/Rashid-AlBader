package com.example.newsapp.screen

import Article
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.Articles.repo.ArticleRepo
import com.example.Articles.repo.CategoryOptions


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, updateArticle: (List<Article>) -> Unit) {
    var articleList by remember(mutableStateOf(ArticleRepo.getArticles( )))
    var selectedCategory by remember { mutableStateOf(CategoryOptions.None) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Keep it empty for cleaner look */ },
                modifier = modifier,
                actions = {
                    // Align the dropdown to the start/left side
                    Box(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        CategoryDropDown(
                            selectedOption = selectedCategory,
                            onSelectedOptionChange = {
                                selectedCategory = it
                                // You can update your articles here based on the selected category
                                // updateArticle(...)
                            }
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
            //ArticleList()
        }
    }
}