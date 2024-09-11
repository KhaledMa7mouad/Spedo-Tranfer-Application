package com.example.spedotransferapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignInViewModelFactory(private val signInHandler: SignInHandler) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignInViewModel(signInHandler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class SignUpViewModelFactory(private val signUpHandler: SignUpHandler ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel(signUpHandler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
