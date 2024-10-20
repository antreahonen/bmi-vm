package com.example.myapplication

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {


    var height by mutableStateOf("")
    var weight by mutableStateOf("")


    val bmi: String
        get() = calculateBmi()


    fun onHeightChange(newHeight: String) {
        height = newHeight
    }


    fun onWeightChange(newWeight: String) {
        weight = newWeight
    }


    private fun calculateBmi(): String {
        val heightInMeters = height.toFloatOrNull()
        val weightInKg = weight.toFloatOrNull()

        if (heightInMeters != null && weightInKg != null && heightInMeters > 0) {
            val bmiValue = weightInKg / (heightInMeters * heightInMeters)
            return String.format("%.2f", bmiValue)
        }

        return "Invalid input"
    }
}
