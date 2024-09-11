package com.example.spedotransferapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.spedotransferapp.models.SignUpResponse
import com.example.spedotransferapp.navigation.Routes
import kotlinx.coroutines.launch

class SignUpViewModel(private val signUpHandler: SignUpHandler) : ViewModel() {

    var signUpResult by mutableStateOf<SignUpResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun signUpUser(name: String, email: String, password: String, country: String, dateOfBirth: String, navController: NavController) {
        isLoading = true
        errorMessage = null

        viewModelScope.launch {
            val response = signUpHandler.signUpUser(name, email, password, country, dateOfBirth)
            if (response != null) {
                signUpResult = response
                navController.navigate(Routes.SIGNIN)
            } else {
                errorMessage = "Failed to sign up"
            }
            isLoading = false
        }
    }
}
