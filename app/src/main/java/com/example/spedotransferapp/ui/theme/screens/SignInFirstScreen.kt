package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import com.example.spedotransferapp.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, modifier: Modifier = Modifier) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed)))
            .padding(top = 32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(text = "Sign Up", color = Color.Black, fontSize = 24.sp)
            Text(
                text = "Speedo Transfer",
                color = Color.Black,
                fontSize = 36.sp,
                modifier = Modifier.padding(top = 48.dp, bottom = 36.dp)
            )
        }
        Column {
            Text(text = "Full Name", color = Color.Black, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp))
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text(text = "Enter your Full Name", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Black
                ),
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.fullname_24), contentDescription = "")
                }
            )
            Text(text = "Email", color = Color.Black, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter your Email", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.outline_email_24), contentDescription = "")
                }
            )
            Text(text = "Password", color = Color.Black, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter your Password", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Black
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (isPasswordVisible) {
                        R.drawable.outline_visibility_off_24
                    } else {
                        R.drawable.visibility_24
                    }
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(painter = painterResource(id = icon), contentDescription = null)
                    }
                },
                isError = passwordError
            )
            if (passwordError) {
                Text(
                    text = "Password must be at least 6 characters with 1 uppercase, 1 lowercase, and 1 special character.",
                    color = Color.Red,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
            Text(
                text = "Confirm Password",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp)
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text(text = "Confirm your Password", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Black
                ),
                visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (isConfirmPasswordVisible) {
                        R.drawable.outline_visibility_off_24
                    } else {
                        R.drawable.visibility_24
                    }
                    IconButton(onClick = { isConfirmPasswordVisible = !isConfirmPasswordVisible }) {
                        Icon(painter = painterResource(id = icon), contentDescription = null)
                    }
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        passwordError = !isValidPassword(password) // Validate password on sign-up
                        if (!passwordError) {
                            // Navigate to next screen or perform sign-up logic
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = modifier.fillMaxWidth(0.9f),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = offred),
                    contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp)
                ) {
                    Text(text = "Sign up", fontSize = 16.sp)
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Already have an account?", color = Color.Gray)
                TextButton(onClick = { navController.navigate(Routes.SIGNIN) }) {
                    Text(text = "Sign In", color = offred, textDecoration = TextDecoration.Underline)
                }
            }
        }
    }
}

// Function to validate password
fun isValidPassword(password: String): Boolean {
    val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{6,}\$")
    return passwordPattern.matches(password)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun prev() {
    SecondScreen(navController = rememberNavController())
}