package com.example.spedotransferapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.offred

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val isButtonEnabled = text.isNotEmpty() && password.isNotEmpty()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
    ) {
        Text(
            text = "Sign In",
            style = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 40.dp)
        )
        Text(
            text = "Speedo Transfer",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.Black

            ),
            modifier = Modifier.padding(top = 60.dp)
        )

        Text(
            text = "Email",
            modifier = Modifier
                .padding(top = 60.dp, start = 16.dp)
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
                focusedTextColor = Color.Black, // Set the text color here
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
                .padding(top = 8.dp, start = 16.dp)
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
            onClick = { navController.navigate(Routes.ONBOARDINGONE)},
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(88.dp)
                .padding(top = 32.dp, start = 10.dp,end=8.dp),

            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonEnabled) offred else Color.Gray
            )
        ){
            Text(
                text = "Sign In"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account?",
                modifier = Modifier
                    .padding(top = 28.dp, end = 4.dp)
                    .clickable { /*TODO*/ },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            TextButton(onClick = { navController.navigate(Routes.FIRSTSIGNUP) }) {
                Text(
                    text = "Sign Up",
                    color = offred,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(top=20.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignInPreview() {
    SignIn(rememberNavController())
}