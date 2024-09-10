package com.example.spedotransferapp.models

data class Customers(
    val name:String,
    val email:String,
    val password:String,
    val country:String,
    val dateOfBirth:String,
    val phoneNumber:String="0xxxxxxxxxx"

)