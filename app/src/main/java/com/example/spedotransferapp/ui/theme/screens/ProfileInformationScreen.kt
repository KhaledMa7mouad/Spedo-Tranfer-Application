package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 32.dp, top = 44.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back",
                tint = colorResource(id = R.color.Gray_G900),
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = "Profile Information",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = colorResource(id = R.color.Gray_G900),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }

        ProfileOptionItem(
            title = "Full Name",
            description = "Mohamed Sherif"
        )
        HorizontalDivider()
        ProfileOptionItem(
            title = "Email",
            description = "Mohamed@gmail.com"
        )
        HorizontalDivider()
        ProfileOptionItem(
            title = "Date Of Birth",
            description = "26/06/2002"
        )
        HorizontalDivider()
        ProfileOptionItem(
            title = "Country",
            description = "Egypt"
        )
        HorizontalDivider()
        ProfileOptionItem(
            title = "Bank Account",
            description = "1234xxxx"
        )
    }
}

@Composable
fun ProfileOptionItem(title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun HorizontalDivider() {
    Divider(color = Color.Gray, thickness = 0.5.dp, modifier = Modifier.padding(horizontal = 16.dp))
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}
