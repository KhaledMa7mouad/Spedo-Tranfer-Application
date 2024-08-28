package com.example.spedotransferapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes{
    const val FIRSTSIGNUP="firstsignup"
    const val SIGNIN="signin"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination =Routes.FIRSTSIGNUP
    )
    {

        composable(route = Routes.FIRSTSIGNUP){
            SecondScreen(navController)
        }
        composable(route = Routes.SIGNIN){
            SignIn(navController)
        }
    }

}