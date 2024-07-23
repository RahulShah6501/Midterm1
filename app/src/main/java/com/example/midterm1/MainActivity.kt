package com.example.midterm1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val spinnerOperations = findViewById<Spinner>(R.id.spinnerOperations)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val num1 = etNumber1.text.toString().toDoubleOrNull()
            val num2 = etNumber2.text.toString().toDoubleOrNull()
            val operation = spinnerOperations.selectedItem.toString()

            if (num1 == null || num2 == null) {
                tvResult.text = "Please enter valid numbers"
                return@setOnClickListener
            }

            val result = when (operation) {
                "Addition" -> num1 + num2
                "Subtraction" -> num1 - num2
                "Multiplication" -> num1 * num2
                "Division" -> {
                    if (num2 == 0.0) {
                        tvResult.text = "Cannot divide by zero"
                        return@setOnClickListener
                    }
                    num1 / num2
                }
                else -> 0.0
            }

            tvResult.text = "Result: $result"
        }
    }
}
