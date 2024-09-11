package com.example.spedotransferapp


import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.navigation.AppNavHost
import com.example.spedotransferapp.ui.theme.SpedoTransferAppTheme
import com.example.spedotransferapp.ui.theme.screens.FirstScreen
import com.example.spedotransferapp.ui.theme.screens.InternetError
import com.example.spedotransferapp.ui.theme.screens.OnBoardingScreen1
import com.example.spedotransferapp.ui.theme.screens.OnboardingNavGraph
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        setContent {
            SpedoTransferAppTheme {
                var showFirstScreen by remember { mutableStateOf(true) }
                var isConnected by remember { mutableStateOf(true) }
                var showOnboarding by remember { mutableStateOf(isFirstTime()) }

                val context = this
                LaunchedEffect(Unit) {
                    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    val networkRequest = android.net.NetworkRequest.Builder()
                        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                        .build()

                    val networkCallback = object : ConnectivityManager.NetworkCallback() {
                        override fun onAvailable(network: Network) {
                            isConnected = true
                        }

                        override fun onLost(network: Network) {
                            isConnected = false
                        }
                    }

                    connectivityManager.registerNetworkCallback(networkRequest, networkCallback)

                    delay(3000)
                    showFirstScreen = false
                }

                if (showFirstScreen) {
                    FirstScreen()
                } else {
                    if (showOnboarding) {
                        OnboardingNavGraph(
                            onOnboardingComplete = {
                                markOnboardingComplete()
                                showOnboarding = false
                            }
                        )
                    } else {
                        if (isConnected) {
                            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                                AppNavHost()
                            }
                        } else {
                            InternetError()
                        }
                    }
                }
            }
        }
    }

    // Check if this is the first time opening the app
    private fun isFirstTime(): Boolean {
        return sharedPreferences.getBoolean("is_first_time", true)
    }

    // Mark onboarding as complete
    private fun markOnboardingComplete() {
        with(sharedPreferences.edit()) {
            putBoolean("is_first_time", false)
            apply()
        }
    }
}


