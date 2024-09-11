package com.example.spedotransferapp.api

data class TransferRequest(
    val senderAccountNumber: String,
    val recipientAccountNumber: String,
    val amount: String,
    val recipientName: String
)

data class TransferResponse(
    val id: Int,
    val senderName: String,
    val senderAccountNumber: String,
    val currency: String,
    val recieverAccountNumber: String,
    val recieverAccountName: String,
    val amountTransferred: Double,
    val createdAt: String
)
