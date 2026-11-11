package com.example.immunepercentageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private lateinit var editTextInput: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextInput = findViewById(R.id.editTextInput)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            calculateImmunePercentage(editTextInput.text.toString())
        }
    }

    private fun calculateImmunePercentage(input: String) {
        try {
            val inputNumber = BigDecimal(input.trim())
            // Placeholder formula: replace with your real calculation
            val immunePercentage = inputNumber
                .multiply(BigDecimal(100))
                .setScale(2, RoundingMode.HALF_UP)

            textViewResult.text = "Immune Percentage: $immunePercentage%"
        } catch (e: NumberFormatException) {
            textViewResult.text = "Please enter a valid number"
        }
    }
}
