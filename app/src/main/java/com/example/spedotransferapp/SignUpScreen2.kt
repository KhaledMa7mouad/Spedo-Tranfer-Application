package com.example.spedotransferapp

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen2(
    navController: NavController,
    fullName: String,
    email: String,
    password: String,
    modifier: Modifier = Modifier
) {
    val country = remember { mutableStateOf<String>("") }
    val mDate = remember { mutableStateOf<String>("") }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.Gredient),
                    titleContentColor = colorResource(id = R.color.Gray_G900),
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
            )
        }
    ) { innerPadding -> SignUp2( country ,mDate )
    }
}

@Composable
fun SignUp2(

    country: MutableState<String>,
    mDate: MutableState<String>,

) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.Greadient2),
                        colorResource(id = R.color.Gredient)
                    ),
                    startY = 2000f,
                    endY = 0f
                )
            )
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Speedo Transfer",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Welcome To Banque Misr!",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Let's complete your profile",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            bottomSheet(country)
            Spacer(modifier = Modifier.height(10.dp))
            DatePickerButton(mDate)
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.Beige)
                ),
                shape = RoundedCornerShape(9.dp),
                enabled = country.value.isNotEmpty() && mDate.value.isNotEmpty()
            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
    }
}

@Composable
fun DatePickerButton(mDate: MutableState<String>) {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            mDate.value = "$dayOfMonth/${month + 1}/$year"
        }, mYear, mMonth, mDay
    )

    Column(
        modifier = Modifier
        //.fillMaxSize()
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Date Of Birth",
            modifier = Modifier.padding(horizontal = 32.dp),
            fontSize = 16.sp,
            color = colorResource(id = R.color.Gray_G700),
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = { mDatePickerDialog.show() },
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(4.dp))
                .background(color = Color.White),
            colors = ButtonDefaults.buttonColors(Color.White),
        ) {
            Text(
                text = if (mDate.value.isNotEmpty()) mDate.value else "DD/MM/YYYY",
                color = if (mDate.value.isNotEmpty()) Color.Black else colorResource(id = R.color.Gray_G70),
                fontSize = 16.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                tint = Color.DarkGray,
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OverAll5() {
    SignUpScreen2(rememberNavController(), "mohamed", "mohamed.com", "101010")
}



