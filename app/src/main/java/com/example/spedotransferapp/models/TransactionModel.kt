package com.example.spedotransferapp.models

data class Transaction(
    val senderName: String,
    val cardNumber: String,
    val transactionType: String,
    val amount: String,
    val date: String,
    val status: String
)
