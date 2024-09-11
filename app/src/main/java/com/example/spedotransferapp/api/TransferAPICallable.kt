package com.example.spedotransferapp.api

import com.example.spedotransferapp.api.TransferRequest
import com.example.spedotransferapp.api.TransferResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PUT

interface TransferAPICallable {
    @PUT("/api/v1/account/transfer")
    fun transferMoney(
        @Header("Authorization") token: String,
        @Body transferRequest: TransferRequest
    ): Call<TransferResponse>
}
