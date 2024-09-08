package com.example.spedotransferapp.ui.theme.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@Composable
fun ServerError(navController: NavController,modifier: Modifier = Modifier) {
    Column (
        modifier= Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
            .padding(top = 24.dp)
    ){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .padding(top=68.dp, start = 40.dp,end=40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.servererror),
                contentDescription ="",
                modifier=Modifier.fillMaxSize()
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)

        ) {
            Text(
                text = "Server error...",
                fontSize = 28.sp,
                fontWeight = FontWeight.W500,
                color = NewGray2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top=4.dp)

            )
            Text(
                text="It seems like we’re haveing some diffculities , please don’t leave your aspirations, we are sending for help",
                color = NewGray,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.padding(top=24.dp)
            )
            Button(
                onClick = { navController.navigate(Routes.ONBOARDINGTHREE) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = offred
                )
            ) {
                Text(
                    text = "Call Us",
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 16.sp
                )
            }
            OutlinedButton(
                onClick = { navController.navigate(Routes.ONBOARDINGTHREE) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = offred
                ),
                border = BorderStroke(2.dp, offred)

            ) {
                Text(
                    text = "Message Us",
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 16.sp
                )
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ServerErrorPreview() {
    ServerError(rememberNavController())
}
