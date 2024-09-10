package com.example.spedotransferapp.ui.theme.screens

import android.app.Notification
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightBlue
import com.example.spedotransferapp.R
import com.example.spedotransferapp.models.NotificationModel

@Composable
fun NotificationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = DarkWhite,
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Notifications",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 64.dp)
                            .wrapContentSize(Alignment.Center),

                        )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation back */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"

                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkWhite)
                    .padding(innerPadding)

            )
            {

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


        }
    )


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
            .fillMaxSize()
            .padding(4.dp)
            .height(120.dp),
        backgroundColor = LightBlue,
    ) {

        Row(
           verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),

        ) {

            Icon(
                painter = painterResource(id = R.drawable.visa_icon),
                contentDescription = "Icon",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = noti.title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Yoy have received 1000 USD from ${noti.senderName} With card number ${noti.cardNumber}"
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
private fun NotificationScreenPrev() {
    NotificationScreen()
}