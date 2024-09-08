package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.R


@Composable
fun SpeedoTransfer(navController: NavController){
        var background = Brush.verticalGradient(
            listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
            startY = 2000f,
            endY = 0f)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(200.dp)
                ) {
                    CircularProgressIndicator(
                        color = Color(0xFFB71C1C),
                        strokeWidth = 8.dp,
                        modifier = Modifier.size(180.dp),
                    )
                    Text(
                        text = "Speedo \n Transfer",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,


                        )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Connecting to Speedo Transfer\nCredit card",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600
                )
            }

        }

    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpeedoTransferScreenPreview() {
    SpeedoTransfer(navController = rememberNavController())
}








