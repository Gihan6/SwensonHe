package com.example.swensonhe.ui.selection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.swensonhe.R
import com.example.swensonhe.ui.fibonacci.FibonacciActivity
import com.example.swensonhe.ui.anagramTask.AngramActivity
import com.example.swensonhe.ui.currencyTask.MainActivity
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        goToAnagramTask()
        goToFibonacciTask()
        goToCurrency()
    }

    private fun goToAnagramTask() {
        tv_anagramTask.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AngramActivity::class.java))
        })
    }

    private fun goToFibonacciTask() {
        tv_fibonacciTask.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, FibonacciActivity::class.java))
        })
    }

    private fun goToCurrency() {
        tv_currencyTask.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })
    }
}