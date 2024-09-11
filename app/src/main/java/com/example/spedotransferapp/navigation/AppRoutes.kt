package com.example.spedotransferapp.navigation
import MainScreenScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


object Routes {
    const val FIRSTSIGNUP = "firstsignup"
    const val SIGNIN = "signin"
    const val ONBOARDINGONE = "onboardingone"
    const val ONBOARDINGTWO = "onboardingtwo"
    const val ONBOARDINGTHREE = "onboardingthree"
    const val TIMEOUT = "timeout"
    const val SETTINGS = "settings"
    const val EDITPROFILE = "editprofile"
    const val EDITPASSWORD = "editpassword"
    const val TRANSFERAMOUNT = "transferamount"
    const val TRANSFERCONFIRMATION = "transferconfirmation"
    const val SUCCESSFULTRANSACTION = "successfultransaction"
    const val NOTIFICATION = "notification"
    const val SIGNUPSECONDSCREEN="signupsecondscreen"
    const val SCAFFOLDSCREEN = "scaffold"
    const val AUTH =   "auth"

}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.AUTH
    )
    {

        authGraph(navController)
        composable(route = Routes.SCAFFOLDSCREEN) {
            MainScreenScaffold()
        }

    }
}