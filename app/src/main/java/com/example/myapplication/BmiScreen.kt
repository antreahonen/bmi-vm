package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BmiScreen(viewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = viewModel.height,
            onValueChange = { viewModel.onHeightChange(it) },
            label = { Text("Height (meters)") },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.weight,
            onValueChange = { viewModel.onWeightChange(it) },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(24.dp))


        Text(text = "Your BMI: ${viewModel.bmi}")

        Spacer(modifier = Modifier.height(24.dp))


        val bmiValue = viewModel.bmi.toFloatOrNull()

        Text(
            text = when {
                bmiValue == null -> "Invalid or extreme value"
                bmiValue <= 18.5f -> "Underweight"
                bmiValue in 18.5f..24.9f -> "Normal weight"
                bmiValue in 25f..29.9f -> "Overweight"
                bmiValue >= 30f -> "Obesity"
                else -> "Invalid or extreme value"
            }
        )
    }
}
