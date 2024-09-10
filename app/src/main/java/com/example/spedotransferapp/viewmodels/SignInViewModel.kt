package com.example.spedotransferapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spedotransferapp.models.SignInResponse
import kotlinx.coroutines.launch

class SignInViewModel(private val signInHandler: SignInHandler) : ViewModel() {

    var signInResult by mutableStateOf<SignInResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun signInUser(email: String, password: String) {
        isLoading = true
        errorMessage = null

        viewModelScope.launch {
            try {
                val response = signInHandler.signInUser(email, password)
                signInResult = response
            } catch (e: Exception) {
                errorMessage = "Failed to sign in: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
