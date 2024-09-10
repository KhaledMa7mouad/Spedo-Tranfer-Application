package com.example.spedotransferapp.api

import com.example.spedotransferapp.models.SignUpResponse
import com.example.spedotransferapp.models.Customers
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountAPICallable {
    @POST("/api/v1/auth/register")
    fun signUp(@Body accountSignup: Customers): Call<SignUpResponse>
}