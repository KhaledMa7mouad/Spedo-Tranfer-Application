package com.example.spedotransferapp

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.offred

@Composable
fun InternetError(modifier: Modifier = Modifier) {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.nointernet),
            contentDescription ="No Internet",
            modifier=Modifier.fillMaxSize(0.34f)
            )
        Text(
            text = "Internet connection disabled...",
            color = NewGray2,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp),
            textAlign = TextAlign.Center,
            )
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.9f).padding(top=32.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = offred
            )

        ) {
            Text(
                text = "Update",
                modifier=Modifier.padding(vertical = 8.dp),
                fontSize = 16.sp,
                )
            
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun InternalErrorPreview() {
    InternetError()
}