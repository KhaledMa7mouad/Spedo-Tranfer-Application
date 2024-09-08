package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.navigation.Routes

@Composable
fun OnboardingNavGraph( onOnboardingComplete: () -> Unit) {
    val nv= rememberNavController()
    NavHost(navController = nv, startDestination = "onboarding1") {
        composable("onboarding1") {
            OnBoardingScreen1(navController = nv,onOnboardingComplete)
        }
        composable("onboarding2") {
            OnBoardingScreen2(navController = nv,onOnboardingComplete)
        }
        composable("onboarding3") {
            OnBoardingScreen3(navController = nv, onOnboardingComplete = onOnboardingComplete)
        }

    }
}
