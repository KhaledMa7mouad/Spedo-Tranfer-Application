package com.example.spedotransferapp.viewmodels

import android.util.Log
import androidx.navigation.NavController
import com.example.spedotransferapp.api.AccountAPIService
import com.example.spedotransferapp.models.SignUpResponse
import com.example.spedotransferapp.models.Customers
import com.example.spedotransferapp.navigation.Routes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpHandler {

    suspend fun signUpUser(name: String, email: String, password: String, country: String, dateOfBirth: String): SignUpResponse? {
        val accountSignup = Customers(name = name, email = email, password = password, dateOfBirth = dateOfBirth, country = country)
        return try {
            val response = AccountAPIService.callable.signUp(accountSignup)
            if (response.isSuccessful) {
                response.body() // return response if successful
            } else {
                // Handle API error
                null
            }
        } catch (e: Exception) {
            // Handle network failure
            null
        }
    }

}
