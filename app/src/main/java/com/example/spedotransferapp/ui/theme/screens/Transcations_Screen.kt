package com.example.spedotransferapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkGreen
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightBlue
import com.example.spedotransferapp.R
import com.example.spedotransferapp.models.Transaction
import com.example.spedotransferapp.navigation.Routes

@Composable
fun TransactionsScreen(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = DarkWhite,
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Transactions",
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Text(
                            text = "Your Last Transactions",
                            style = MaterialTheme.typography.h6,
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(transactionsData) { transaction ->
                            TransactionItem(navController ,transaction)
                            Log.d("trace", "Displaying transaction")
                        }
                    }
                }


            }


        }
    )
}







@Composable
fun TransactionItem(navController: NavController, transaction: Transaction) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            Icon(
                painter = painterResource(id = R.drawable.mastercard),
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
                    text = transaction.senderName,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${transaction.cardNumber} - ${transaction.transactionType}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = transaction.amount,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .width(64.dp)
                //  .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Card",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate(route = Routes.SUCCESSFULTRANSACTION)
                        }
                )
                Box(

                    modifier = Modifier
                        .background(DarkWhite)

                ) {
                    Text(
                        text = transaction.status,
                        style = MaterialTheme.typography.caption,
                        color = if (transaction.status == "Successful") DarkGreen else Color.Red
                    )
                }
            }
        }
    }
}



val transactionsData = listOf(
    Transaction(
        senderName = "Ahmed Mohamed",
        cardNumber = "Visa. Mater Card. 1234",
        transactionType = "Received",
        amount = "$1000",
        date = "Today 11:00",
        status = "Successful"
    ),
    Transaction(
        senderName = "Ahmed Mohamed",
        cardNumber = "Visa. Mater Card. 1234",
        transactionType = "Received",
        amount = "$1000",
        date = "Today 11:00",
        status = "Failed"
    ),
    Transaction(
        senderName = "Ahmed Mohamed",
        cardNumber = "Visa. Mater Card. 1234",
        transactionType = "Received",
        amount = "$1000",
        date = "Today 11:00",
        status = "Successful"
    )
)



@Composable
fun SuccessTransactionScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Successful Transactions") },
                backgroundColor = DarkWhite,
                elevation = 0.dp,

                navigationIcon = {
                    IconButton(onClick = {
                   navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },

                contentColor = Color.Black, // Color of the text and icons

            )
        }
    ) { paddingValues ->
        // Main content within the Scaffold
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF3E7)) // Background Color
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Section - Checkmark with Gradient Circle
            Image(
                painter = painterResource(id = R.drawable.checked),
                contentDescription = "Success",
                modifier = Modifier.size(128.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Transfer Amount Section
            Text(
                text = "1000 USD",
                fontSize = 28.sp,
                color = Color(0xFFD73E00),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Transfer amount",
                fontSize = 16.sp,
                color = Color(0xFF948480),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            TextButton(onClick = { /* TODO: Add send money functionality */ }) {
                Text(text = "Send money", color = Color(0xFF9C2810))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sender Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFBEC5CE), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "From",
                        fontSize = 14.sp,
                        color = Color(0xFF9E8178),
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Asmaa Dosuky", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Account xxxx7890", fontSize = 14.sp, color = Color(0xFF9E8178))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Receiver Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFBEC5CE), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "To",
                        fontSize = 14.sp,
                        color = Color(0xFF9E8178),
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Jonathon Smith", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Account xxxx7890", fontSize = 14.sp, color = Color(0xFF9E8178))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightBlue, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),

            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Space between rows
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Transfer amount", color = Color(0xFF9E8178) , fontWeight = FontWeight.Bold)
                        Text(text = "48.4220 EGP", color = Color(0xFF9E8178))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Reference", color = Color(0xFF9E8178) , fontWeight = FontWeight.Bold)
                        Text(text = "123456789876", color = Color(0xFF9E8178))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Date", color = Color(0xFF9E8178), fontWeight = FontWeight.Bold)
                        Text(text = "20 Jul 2024 7:50 PM", color = Color(0xFF9E8178))
                    }
                }
            }


        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun TransactionsScreenPrev() {
    TransactionsScreen(rememberNavController())
}

@Preview(showSystemUi = true)
@Composable
private fun SuccessfulTransactionScreenPrev() {
    SuccessTransactionScreen(rememberNavController())
}
