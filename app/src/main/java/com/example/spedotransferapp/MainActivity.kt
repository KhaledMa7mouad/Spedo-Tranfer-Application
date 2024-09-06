package com.example.spedotransferapp
import MainScreenScaffold
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.spedotransferapp.ui.theme.SpedoTransferAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpedoTransferAppTheme {
//                var showFirstScreen by remember { mutableStateOf(true) }
//                var isConnected by remember { mutableStateOf(true) }
//
//                val context = this
//                LaunchedEffect(Unit) {
//                    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//                    val networkRequest = android.net.NetworkRequest.Builder()
//                        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//                        .build()
//
//                    val networkCallback = object : ConnectivityManager.NetworkCallback() {
//                        override fun onAvailable(network: Network) {
//                            isConnected = true
//                        }
//
//                        override fun onLost(network: Network) {
//                            isConnected = false
//                        }
//                    }
//
//                    connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
//
//                    delay(3000)
//                    showFirstScreen = false
//                }
//
//                if (showFirstScreen) {
//                    FirstScreen()
//                } else {
//                    if (isConnected) {
//                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                            AppNavHost()
//                        }
//                    } else {
//                        InternetError()
//                    }
//                }

                MainScreenScaffold()

            }
        }
    }
}

