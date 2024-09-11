package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.NewGray3
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes
import com.example.spedotransferapp.viewmodels.SignInViewModel
import com.example.spedotransferapp.viewmodels.SignInViewModelFactory
import com.example.spedotransferapp.viewmodels.SignUpHandler
import com.example.spedotransferapp.viewmodels.SignUpViewModel
import com.example.spedotransferapp.viewmodels.SignUpViewModelFactory
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpSecondScreen(
    name:String,
    email:String,
    password:String,
    navController: NavController,
    signUpHandler: SignUpHandler,
    modifier: Modifier = Modifier
) {

    var selectedCountry by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val countries = listOf("USA", "Italy", "Germany", "France", "India", "Egypt")
    var dateBtn by remember { mutableStateOf("Choose a date") }
    var dateFlag by remember {
        mutableStateOf(false)
    }
    var dateMillis by remember { mutableLongStateOf(0L) }


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
                        navController.navigate(Routes.FIRSTSIGNUP)
                    }
                    .padding(start = 12.dp)
            )

        }

        Text(
            text = "Speedo Transfer",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            color = NewGray2,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )
        Text(
            text = "Welcome to Banque Misr!",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp),
            color = NewGray2,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )
        Text(
            text = "Let’s Complete your Profile",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            color = NewGray2,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )

        Text(
            text = "Country",
            fontSize = 16.sp,
            color = NewGray3,
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp, top = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                OutlinedTextField(
                    value = selectedCountry,
                    onValueChange = { selectedCountry = it },
                    label = { Text("Choose a country") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(0.9f)
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    countries.forEach { country ->
                        DropdownMenuItem(
                            text = { Text(country) },
                            onClick = {
                                selectedCountry = country
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
        Text(
            text = "Date Of Birth",
            fontSize = 16.sp,
            color = NewGray3,
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp, top = 16.dp)
        )
        if (dateFlag){
            DatePickerChooser(
                onConfirm = {
                    it.selectedDateMillis?.let { selectedMillis ->
                        val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
                        dateBtn = dateFormatter.format(selectedMillis)
                        dateMillis = selectedMillis
                    }
                    dateFlag = false
                },
                onDismiss = { dateFlag = false }
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = dateBtn,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(0.9f),
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { dateFlag=!dateFlag }) {
                        Icon(painter = painterResource(id = R.drawable.outline_calendar_month_24), contentDescription ="Date")
                    }
                },

                )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            val viewModel: SignUpViewModel = viewModel(
                factory = SignUpViewModelFactory(signUpHandler)
            )

            viewModel.errorMessage?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }

            if (viewModel.isLoading) {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
            Button(
                onClick = {
                    viewModel.signUpUser(name, email, password, selectedCountry, dateBtn, navController)
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = offred
                )
            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SecondSignup() {


    SignUpSecondScreen(
        name = "atef",
        email = "atef@gmail.com",
        password = "11111234",
        signUpHandler = SignUpHandler(),
        navController = rememberNavController()
    )
}
