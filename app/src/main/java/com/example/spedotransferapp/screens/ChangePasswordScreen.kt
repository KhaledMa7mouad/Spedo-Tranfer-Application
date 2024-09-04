package com.example.spedotransferapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.NewGray3
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPasswordScreen(navController: NavController) {
    var newPassword by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 32.dp, top = 44.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = NewGray2,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.navigate(Routes.SETTINGS)
                    }
                    .padding(start = 12.dp)
            )
            Text(
                text = "Change Password",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = NewGray2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }

        Text(
            text = "Current Password",
            fontSize = 16.sp,
            color = NewGray3,
            modifier = Modifier.padding(start = 24.dp, bottom = 4.dp, top = 16.dp)
        )
        var isPasswordVisible by remember {
            mutableStateOf(false)
        }
        OutlinedTextField(
            value =password ,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Enter your Current Password",color= Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp
                ),
            keyboardOptions = KeyboardOptions(
                keyboardType= KeyboardType.Password
            ),

            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (isPasswordVisible) {
                    R.drawable.outline_visibility_off_24
                } else {
                    R.drawable.visibility_24
                }
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(painter = painterResource(id = icon), contentDescription = null)
                }
            }


        )
        Text(
            text = "New Password",
            fontSize = 16.sp,
            color = NewGray3,
            modifier = Modifier.padding(start = 24.dp, bottom = 4.dp, top = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
           OutlinedTextField(
                value = newPassword,
                onValueChange = {
                    newPassword = it
                },
                label = {
                    Text(text = "Enter your New Password",color= Color.Gray)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType= KeyboardType.Password
                ),

                visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (isPasswordVisible) {
                        R.drawable.outline_visibility_off_24
                    } else {
                        R.drawable.visibility_24
                    }
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(painter = painterResource(id = icon), contentDescription = null)
                    }
                }


            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = offred
                )
            ) {
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EditPasswordScreenPrev() {
    EditPasswordScreen(rememberNavController())
}

