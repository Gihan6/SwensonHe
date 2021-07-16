package com.example.swensonhe.ui.fibonacci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swensonhe.R
import kotlinx.android.synthetic.main.activity_fibonacci.*

class FibonacciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)
        tv_result.text = generateFibonacciNumber()
    }

    private fun generateFibonacciNumber(): String {
        var series = ""

        // Set it to the number of elements you want in the Fibonacci Series
        val maxNumber = 9
        var previousNumber = 0
        var nextNumber = 1
        for (i in 1..maxNumber) {

            val sum = previousNumber + nextNumber
            previousNumber = nextNumber
            nextNumber = sum

            series += previousNumber
        }

        return series
    }

}