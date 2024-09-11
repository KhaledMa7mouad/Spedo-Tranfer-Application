package com.example.spedotransferapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.example.spedotransferapp.ui.theme.screens.SecondScreen
import com.example.spedotransferapp.ui.theme.screens.SignIn
import com.example.spedotransferapp.ui.theme.screens.Timeout
import com.example.spedotransferapp.viewmodels.SignInHandler

fun NavGraphBuilder.authGraph(navController: NavController) {

    navigation(startDestination = Routes.FIRSTSIGNUP, route = Routes.AUTH) {

        composable(route = Routes.FIRSTSIGNUP) {
            SecondScreen(navController)
        }
        composable(route = Routes.SIGNIN) {
            SignIn(navController, signInHandler = SignInHandler())
        }

        composable(route = Routes.TIMEOUT) {
            Timeout(navController)
        }

    }
}