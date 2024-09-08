package com.example.spedotransferapp.models

data class NotificationModel(
    val title : String = "Receive Transaction",
    val senderName : String,
    val date : String,
    val cardNumber : String,

)
