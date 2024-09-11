package com.example.spedotransferapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TransferApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://speedo-transfer-437e318f5416.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: TransferAPICallable by lazy {
        retrofit.create(TransferAPICallable::class.java)
    }
}
