package com.example.spedotransferapp.models

data class Customers(
    val name:String,
    val email:String,
    val password:String,
    val country:String="EGY",
    val dateOfBirth:String="2004-04-24",
    val phoneNumber:String="01202868440"

)