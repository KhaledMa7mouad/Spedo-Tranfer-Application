package com.example.spedotransferapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransfareAmountScreen(navController: NavHostController) {
    var amount by remember {
        mutableStateOf("")
    }
    var recipientName by remember {
        mutableStateOf("")
    }
    var recipientAccount by remember {
        mutableStateOf("")
    }
    var favDialog by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
            .padding(horizontal = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp, top = 20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = NewGray2,
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.navigate(Routes.SETTINGS)
                    }

            )
            Text(
                text = "Transfare",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = NewGray2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }
        Image(
            painter = painterResource(id = R.drawable.transfareamountscreen),
            contentDescription = "Transfer Amount Screen",
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.CenterHorizontally)
                .height(37.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {
            Text(
                text = "Amount",
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),

                )
            Text(
                text = "Confirmation",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
                )
            Text(
                text = "Payment",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
                )
        }
        Text(
            text ="How much are you sending?",
            modifier = Modifier.padding(top=8.dp, bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(colors = listOf(Color.White, Color.White))
                )

        ) {
            Text(
                text = "Amount",
                color = NewGray2,
                fontSize = 16.sp,
                )
            OutlinedTextField(
                value =amount ,
                onValueChange = {amount=it},
                modifier = Modifier
                    .fillMaxWidth(0.98f)
                    .padding(bottom = 12.dp, top = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ){
            Text(
                text ="Recipient Information",
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)

            )
            Row(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.Bottom)
                    .padding(start = 64.dp)
                    .clickable {
                        favDialog=true
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_star_border_24),
                    contentDescription = "",
                    tint = offred
                )
                Text(
                    text ="Favourite",
                    fontSize = 14.sp,
                    color = offred,
                    modifier = Modifier.padding(top=4.dp, start = 4.dp,end=4.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.outline_arrow_forward_ios_24),
                    contentDescription = "",
                    tint = offred,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(top = 8.dp)
                )


            }
            if(favDialog){
                FavouriteListDialog(onDismiss = {
                    favDialog=false
                })
            }
        }
        Text(
            text = "Recipient Name",
            color = NewGray2,
            fontSize = 16.sp,
            modifier = Modifier.padding(top=32.dp)
        )
        OutlinedTextField(
            value =recipientName ,
            onValueChange = {recipientName=it},
            modifier = Modifier
                .fillMaxWidth(0.98f)
                .padding(bottom = 12.dp, top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            label = {
                Text(text = "Enter Recipient Name")
            }
        )
        Text(
            text = "Recipient Account",
            color = NewGray2,
            fontSize = 16.sp,
        )
        OutlinedTextField(
            value =recipientAccount ,
            onValueChange = {recipientAccount=it},
            modifier = Modifier
                .fillMaxWidth(0.98f)
                .padding(bottom = 12.dp, top = 4.dp),
            shape = RoundedCornerShape(8.dp),
            label = {
                Text(text = "Enter Percipient Account Number")
            }
        )
        Button(
            onClick = {
                Log.d("trace", "Navigating with amount: $amount, name: $recipientName, account: $recipientAccount")

                navController.navigate(

                    "${Routes.TRANSFERCONFIRMATION}/${amount}/${recipientName}/${recipientAccount}"
                )
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = offred
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Continue",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 12.dp)
                )
        }




    }
}

@Preview(showBackground = true)
@Composable
fun TransfareAmountScreenPrev() {
    TransfareAmountScreen(rememberNavController())
}
@Composable
fun FavouriteListDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Close")
            }
        },
        title = {
            Text(text = "Favourite List", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        },
        text = {
            Column {
                // Sample Favourite Items
                FavouriteItem(name = "Asmaa Dosuky", account = "Account xxxx7890")
                Spacer(modifier = Modifier.height(8.dp))
                FavouriteItem(name = "Mohamed Atef", account = "Account xxxx7890")
            }
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun FavouriteItem(name: String, account: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Handle item click */ },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_account_balance_24),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name, fontWeight = FontWeight.Bold)
                Text(text = account, color = Color.Gray)
            }
        }
    }
}