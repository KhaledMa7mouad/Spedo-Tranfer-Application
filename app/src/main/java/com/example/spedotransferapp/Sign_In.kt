package com.example.spedotransferapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun SignIn(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val isButtonEnabled = text.isNotEmpty() && password.isNotEmpty()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Sign In",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(top = 40.dp)
        )
        Text(
            text = "Speedo Transfer",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center

            ),
            modifier = Modifier.padding(top = 60.dp)
        )

        Text(
            text = "Email",
            modifier = Modifier
                .padding(top = 60.dp, start = 36.dp)
                .align(Alignment.Start),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Enter your address") },
            modifier = Modifier
                .width(408.dp)
                .padding(top = 8.dp, start = 36.dp)
                .align(Alignment.Start),
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
                .padding(top = 8.dp, start = 36.dp)
                .align(Alignment.Start),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .width(408.dp)
                .padding(top = 8.dp, start = 36.dp)
                .align(Alignment.Start),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible)
                    painterResource(id = R.drawable.visibility) // Replace with your visibility icon
                else painterResource(id = R.drawable.unvisibility) // Replace with your visibility off icon

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = icon, contentDescription = "Toggle password visibility")
                }
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            )

        Button(
            onClick = { },
            modifier = Modifier
                .width(408.dp)
                .height(88.dp)
                .padding(top = 32.dp, start = 36.dp)
                .align(Alignment.Start)
            ,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonEnabled) Color(
                    red = 189,
                    green = 52,
                    blue = 70
                ) else Color.Gray
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
                    .clickable { },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                // Only needed once
                color = Color.Gray
            )


            Text(
                text = "Sign Up",
                modifier = Modifier
                    .padding(top = 28.dp)
                    .clickable {},
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,

                textDecoration = TextDecoration.Underline, // Only needed once
                color = Color.Red
            )
        }




    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignInPreview() {
    SignIn()
}