package com.example.spedotransferapp.api

import com.example.spedotransferapp.models.SignInRequest
import com.example.spedotransferapp.models.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface SignINAPICallable {
    @POST("/api/v1/auth/login")
    suspend fun signIn(@Body signInRequest: SignInRequest): Response<SignInResponse>
}
