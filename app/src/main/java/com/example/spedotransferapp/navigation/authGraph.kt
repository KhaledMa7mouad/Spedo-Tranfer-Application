package com.example.spedotransferapp.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation

import com.example.spedotransferapp.ui.theme.screens.SecondScreen
import com.example.spedotransferapp.ui.theme.screens.SignIn
import com.example.spedotransferapp.ui.theme.screens.SignUpSecondScreen
import com.example.spedotransferapp.ui.theme.screens.Timeout
import com.example.spedotransferapp.ui.theme.screens.TransferConfirmationLastScreen
import com.example.spedotransferapp.ui.theme.screens.TransferConfirmationScreen
import com.example.spedotransferapp.viewmodels.SignInHandler
import com.example.spedotransferapp.viewmodels.SignUpHandler

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
        composable(
            route = "${Routes.SIGNUPSECONDSCREEN}/{name}/{email}/{password}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!

            SignUpSecondScreen(
                name = name,
                email = email,
                password = password,
                navController = navController,
                signUpHandler = SignUpHandler()
            )
        }




    }
}