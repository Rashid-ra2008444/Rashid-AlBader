package com.example.viewmodel.screen

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.vm.myViewModel

@Composable
fun Screen2() {
    val myViewModel : myViewModel = viewModel()
    Text(
        text = "Screen 2 number of times clicked is ${myViewModel.counter.value}",
        modifier = Modifier.clickable { myViewModel.increment()},
        fontSize = 20.sp,
    )

}
