package com.example.firsttime

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firsttime.ui.theme.FirstTimeTheme
import com.example.firsttime.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
@Composable
fun OnBoarding(modifier: Modifier = Modifier, updateShowOnBoarding :(Boolean) -> Unit){
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background)
    {
            Column {
            Text("Welcome to Android App Dev")
            Button(onClick = { /*TODO*/ }) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun ShowOnBoarding(showOnBoarding: Boolean, updateShowOnBoarding: (Boolean) -> Unit){
    if (showOnBoarding){
        OnBoarding(updateShowOnBoarding = updateShowOnBoarding)
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
//    create a list of five names with different name sizes
    val names = listOf(
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. JUJU"
    )
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
//        Column(modifier = modifier.padding(vertical = 4.dp)) {
//            for (name in names) {
//
//            }
//        }

        LazyColumn {
            items(names){
                Greeting(it)
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }


    Surface(modifier = modifier, color = MaterialTheme.colorScheme.primary) {
        Row(modifier = Modifier.padding(bottom = 8.dp))
        {
            Column(modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, bottom = if (expanded) 18.dp else 0.dp)
                .background(color = White)) {
                Text(text = "Hello,  ", color = Pink40)
                Text(text = name, color = Pink40)
            }
            ElevatedButton(onClick = {
                expanded = !expanded
                Log.d("EXPANDED", " ---> " + expanded)
                })
                {
                Text(text = if (expanded) "Show less" else "Show more")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTimeTheme {
        Greeting("Android")
    }
}