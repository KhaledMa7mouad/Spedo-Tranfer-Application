package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TransactionsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Transactions",
                     textAlign = TextAlign.Center,

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
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Your Last Transactions",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(transactionsData) { transaction ->
                        TransactionItem(transaction)
                    }
                }
            }
        }
    )
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = transaction.senderName,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${transaction.cardNumber} - ${transaction.transactionType}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "${transaction.amount} - ${transaction.date}",
                    style = MaterialTheme.typography.body2
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .width(64.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Card",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = transaction.status,
                    style = MaterialTheme.typography.caption,
                    color = if (transaction.status == "Successful") Color.Green else Color.Red
                )
            }
        }
    }
}

data class Transaction(
    val senderName: String,
    val cardNumber: String,
    val transactionType: String,
    val amount: String,
    val date: String,
    val status: String
)

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
@Preview(showSystemUi = true)
@Composable
private fun TransactionsScreenPrev() {
    TransactionsScreen()
}
