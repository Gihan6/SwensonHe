package com.example.swensonhe.ui.anagramTask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.swensonhe.R
import kotlinx.android.synthetic.main.activity_angram.*
import java.util.*

class AngramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angram)


        test()

    }

    private fun test() {
        btn_test.setOnClickListener(View.OnClickListener {
            if (!et_firstString.text.isNullOrEmpty() && !et_secondString.text.isNullOrEmpty()) {
                if (anagram(et_firstString.text.toString(), et_secondString.text.toString())) {
                    tv_result.text = getString(R.string.anagram)
                } else {
                    tv_result.text = getString(R.string.not_anagram)
                }
            }
        })
    }

    private fun anagram(string1: String, string2: String): Boolean {

        var s1 = string1.replace("\\s", "")
        var s2 = string2.replace("\\s", "")
        var isAnagram = true
        if (s1.length != s2.length) {
            isAnagram = false
        } else {
            var arrayS1 = s1.toLowerCase().toCharArray()
            var arrayS2 = s2.toLowerCase().toCharArray()
            Arrays.sort(arrayS1)
            Arrays.sort(arrayS2)
            isAnagram = arrayS1.contentEquals(arrayS2)

        }
        return isAnagram

    }

}