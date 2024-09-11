package com.example.spedotransferapp.models


data class Account(
    val id: Int,
    val accountNumber: String,
    val accountType: String,
    val balance: Double,
    val currency: String,
    val accountName: String,
    val accountDescription: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)

data class SignUpResponse(
    val id: Int,
    val name: String,
    val email: String,
    val dateOfBirth: String,
    val country: String,
    val createdAt: String,
    val updatedAt: String,
    val phoneNumber: String,
    val accounts: List<Account>
)
