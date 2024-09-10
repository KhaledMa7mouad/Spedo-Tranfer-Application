package com.example.spedotransferapp.viewmodels

import androidx.navigation.NavController
import com.example.spedotransferapp.api.AccountAPIService
import com.example.spedotransferapp.api.SignINAPICallable
import com.example.spedotransferapp.api.SignInAPIService
import com.example.spedotransferapp.models.SignInRequest
import com.example.spedotransferapp.models.SignInResponse

class SignInHandler {
    suspend fun signInUser(email: String, password: String): SignInResponse? {
        val signInRequest = SignInRequest(email, password)
        return try {
            val response = SignInAPIService.callable.signIn(signInRequest)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {

            null
        }
    }
}
