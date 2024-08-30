package com.example.spedotransferapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.spedotransferapp.ui.theme.SpedoTransferAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpedoTransferAppTheme {
//                var showFirstScreen by remember { mutableStateOf(true) }
//
//                LaunchedEffect(Unit) {
//                    delay(3000)
//                    showFirstScreen = false
//                }
//                if (showFirstScreen) {
//                    FirstScreen()
//                } else {
//                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                        AppNavHost()
//                    }

                Timeout()
                }
            }
        }
    }

