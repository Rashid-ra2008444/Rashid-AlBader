package com.example.practiceforfinal.ui.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(){

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phoneNum by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var workAt by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = firstName,
                onValueChange = {firstName = it},
                label = { Text(text = "FirstName")},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            TextField(
                value = lastName,
                onValueChange = {lastName = it},
                label = { Text(text = "LastName")},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            TextField(
                value = phoneNum,
                onValueChange = {phoneNum = it},
                label = { Text(text = "Phone number")},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            TextField(
                value = dob,
                onValueChange = {dob = it},
                label = { Text(text = "Date of Birth")},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            TextField(
                value = workAt,
                onValueChange = {workAt = it},
                label = { Text(text = "Work at")},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            Button(
                onClick = { /*TODO*/ }
            )
            {

            }
        }
    }

}

