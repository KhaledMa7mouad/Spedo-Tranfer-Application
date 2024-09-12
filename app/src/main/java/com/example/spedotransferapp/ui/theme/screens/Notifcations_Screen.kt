package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.LightBlue
import com.example.spedotransferapp.R
import com.example.spedotransferapp.models.NotificationModel


@Composable
fun NotificationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(notificationsData) { noti ->
                NotificationItem(noti = noti)
            }
        }
    }
}

val notificationsData = listOf(
    NotificationModel(
        senderName = "Asmma Dosouky",
        cardNumber = "1234 xxx",
        date = "12 Jul 2024 09:00 PM"
    ),
    NotificationModel(
        senderName = "Khaled Mahmoud",
        cardNumber = "8544 xxx",
        date = "12 Jul 2024 09:55 PM"
    ),
    NotificationModel(
        senderName = "Kareem Ahmed",
        cardNumber = "9867 xxx",
        date = "12 Jul 2024 11:20 PM"
    ),
)

@Composable
fun NotificationItem(noti: NotificationModel) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(120.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = LightBlue), // Material3 color
        elevation = androidx.compose.material3.CardDefaults.cardElevation(4.dp)  // Material3 elevation
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Person,  // Replace with a default icon like CreditCard
                contentDescription = "Notification",  // Describe the icon for accessibility
                modifier = Modifier.size(32.dp)  // Set the size as needed
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "You have received 1000 USD from ${noti.senderName} with card number ${noti.cardNumber}",
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = noti.date,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotificationScreenPreview() {
    NotificationScreen(rememberNavController())
}
