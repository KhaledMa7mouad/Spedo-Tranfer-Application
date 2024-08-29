package com.example.spedotransferapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTextFields(string1: String, string2: String, state: MutableState<String>, modifier: Modifier = Modifier) {
    var isExpanded by remember {
        mutableStateOf(false)
    }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = string1,
            modifier = Modifier.padding(horizontal = 32.dp),
            fontSize = 16.sp,
            color = colorResource(id = R.color.Gray_G700),
            fontWeight = FontWeight.W400,
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            OutlinedTextField(
                value = state.value,
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    Text(
                        text = string2,
                        color = colorResource(id = R.color.Gray_G70)
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .background(color = Color.White)
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("US") },
                    onClick = {
                        state.value = "US"
                        isExpanded = false
                    },
                    modifier = modifier.background(color = Color.White)
                )
                DropdownMenuItem(
                    text = { Text("US") },
                    onClick = {
                        state.value = "US"
                        isExpanded = false
                    },
                    modifier = modifier.background(color = Color.White)
                )
                DropdownMenuItem(
                    text = { Text("US") },
                    onClick = {
                        state.value = "US"
                        isExpanded = false

                    },
                    modifier = modifier.background(color = Color.White)
                )
            }
        }
    }
}