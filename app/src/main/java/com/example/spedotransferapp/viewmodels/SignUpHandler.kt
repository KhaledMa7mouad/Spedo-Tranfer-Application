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

    fun signUpUser(name: String, email: String, password: String,navController: NavController) {
        val accountSignup = Customers(name = name, email = email, password = password)

        val call = AccountAPIService.callable.signUp(accountSignup)
        call.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                if (response.isSuccessful) {
                    val signUpResponse = response.body()
                    signUpResponse?.let {
                        navController.navigate(Routes.SIGNIN)
                    }
                } else {

                    Log.d("SignUp", "API error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                // Handle failure due to network issues
                Log.d("SignUp", "Network failure: ${t.message}")
            }
        })
    }
}
