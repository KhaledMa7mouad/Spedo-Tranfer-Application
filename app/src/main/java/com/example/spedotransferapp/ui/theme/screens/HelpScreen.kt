package com.example.spedotransferapp.ui.theme.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.R

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Help Information",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactOptions(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current

                ContactCard(
                    icon = R.drawable.email,
                    text = "Send Email",
                    onClick = {
                        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:example@example.com")
                            putExtra(Intent.EXTRA_SUBJECT, "Subject")
                            putExtra(Intent.EXTRA_TEXT, "Body")
                        }
                        context.startActivity(emailIntent)
                    }
                )

                ContactCard(
                    icon = R.drawable.telephone,
                    text = "Call Us",
                    phoneNumber = "0000000",
                    onClick = {
                        val callIntent = Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:0000000")
                        }
                        context.startActivity(callIntent)
                    }
                )
            }
        }
    }
}

@Composable
fun ContactCard(icon: Int, text: String, phoneNumber: String? = null, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .height(120.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F5F5)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color(0xFF8A1538),
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color(0xFF8A1538)
            )
        }
    }
}

@Composable
fun MyAppNavHost(navController: NavController) {
    NavHost(navController = navController as NavHostController, startDestination = "more") {
        composable("more") {
            MoreScreen(navController = navController)
        }
        composable("help") {
            HelpScreen()
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ContactOptionsPreview() {
    val navController = rememberNavController()
    MoreScreen(navController = navController)
}
