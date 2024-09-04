package com.example.spedotransferapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Timeout(navController: NavController, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) } // Controls dialog visibility
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Show the dialog if showDialog is true
        if (showDialog) {
            TimeoutDialog(onDismiss = { showDialog = false })
        }

        // Content below the dialog
        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp , top = 32.dp)
        )

        Text(
            text = "Login to your account",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp , top = 8.dp)
        )


        Text(
            text = "Email",
            modifier = Modifier
                .padding(top = 60.dp, start = 16.dp , bottom = 8.dp)
                .align(Alignment.Start),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )


        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Enter your address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.Black
            ),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = ""
                )
            }
        )

        Text(
            text = "Password",
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .align(Alignment.Start),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black, // Set the text color here
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.Black
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible)
                    painterResource(id = R.drawable.visibility)
                else painterResource(id = R.drawable.unvisibility)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = icon, contentDescription = "Toggle password visibility")
                }
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            )


        Button(
            onClick = { navController.navigate(Routes.SIGNIN) },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(88.dp)
                .padding(top = 32.dp, start = 10.dp,end=8.dp),

            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = offred
            )
        ){
            Text(
                text = "Sign In"
            )
        }

    }
}

@Composable
fun TimeoutDialog(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5)),
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp
        ) {
            // Dialog content here
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Icon with circular background
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEB5757)), // Red color background
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.warning), // Replace with your warning icon
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "We logged you out because you were inactive for 2 minutes – it’s to help your account secure",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    }
                }
            }
        }

        IconButton(
            onClick = {
                onDismiss() // Call the callback when the button is clicked
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    Timeout(navController = rememberNavController())
}