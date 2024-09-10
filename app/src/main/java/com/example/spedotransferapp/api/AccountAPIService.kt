package com.example.spedotransferapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AccountAPIService {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://money-transfer-service.onrender.com")
        .client(client)  // Add the logging client here
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable by lazy {
        retrofit.create(AccountAPICallable::class.java)
    }
}
