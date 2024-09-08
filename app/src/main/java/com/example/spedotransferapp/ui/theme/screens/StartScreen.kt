package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.gittest.ui.theme.offred

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(offred)
    ) {
        Text(
            text = "Speedo Transfer",
            fontSize = 32.sp,
            color = Color.White
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun prev() {
    FirstScreen()
}