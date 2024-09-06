package com.example.spedotransferapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Routes{
    const val FIRSTSIGNUP="firstsignup"
    const val SIGNIN="signin"
    const val ONBOARDINGONE="onboardingone"
    const val ONBOARDINGTWO="onboardingtwo"
    const val ONBOARDINGTHREE="onboardingthree"
    const val TIMEOUT = "timeout"
    const val SETTINGS="settings"
    const val EDITPROFILE="editprofile"
    const val EDITPASSWORD="editpassword"
    const val TRANSFERAMOUNT="transferamount"
    const val TRANSFERCONFIRMATION = "transferconfirmation/{amount}/{name}/{account}"

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
        composable(route = Routes.ONBOARDINGONE){
            OnBoardingScreen1(navController)
        }
        composable(route = Routes.ONBOARDINGTWO){
            OnBoardingScreen2(navController)
        }
        composable(route = Routes.ONBOARDINGTHREE){
            OnBoardingScreen3(navController)
        }
        composable(route = Routes.TIMEOUT){
            Timeout(navController)
        }
        composable(route = Routes.SETTINGS){
            SettingsScreen(navController)
        }
        composable(route = Routes.EDITPROFILE){
            EditProfileScreen(navController)
        }
        composable(route = Routes.EDITPASSWORD){
            EditPasswordScreen(navController)
        }
        composable(route = Routes.TRANSFERAMOUNT){
            TransfareAmountScreen(navController)
        }
        composable(
            route = Routes.TRANSFERCONFIRMATION,
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("amount") { type = NavType.StringType },
                navArgument("account") { type = NavType.StringType }
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val amount = it.arguments?.getString("amount")!!
            val account = it.arguments?.getString("account")!!
            TransferConfirmationScreen(
                amount = amount,
                recipientName = name,
                recipientAccount = account,
                navController = navController
            )
        }
    }

}