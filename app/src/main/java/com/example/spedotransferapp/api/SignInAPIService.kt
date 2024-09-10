package com.example.spedotransferapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignInAPIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://money-transfer-service.onrender.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: SignINAPICallable by lazy {
        retrofit.create(SignINAPICallable::class.java)
    }
}