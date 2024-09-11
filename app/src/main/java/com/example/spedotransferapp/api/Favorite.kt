package com.example.spedotransferapp.api

data class FavoritesRequest(
    val recipientAccountName: String,
    val recipientAccountNumber: String
)

data class FavoritesResponse(
    val recipientAccountName: String,
    val recipientAccountNumber: String
)
