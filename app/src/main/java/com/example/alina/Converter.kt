package com.example.alina

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class Converter : AppCompatActivity() {
    private var number : EditText? = null
    private var initial : EditText? = null
    private var finite : EditText? = null
    private var buttonTranslate : Button? = null
    private var textAnswer : TextView? = null
    private var calculator : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
        number = findViewById(R.id.number)
        initial = findViewById(R.id.initial)
        finite = findViewById(R.id.finite)
        buttonTranslate = findViewById(R.id.translate)
        textAnswer = findViewById(R.id.answer)
        calculator = findViewById(R.id.button6)
        calculator?.setOnClickListener {
            val intent2 = Intent(this, Calculator::class.java)
            startActivity(intent2)
            finish()
        }
        buttonTranslate?.setOnClickListener {
            val num: String = number?.text.toString()
            val startSystem: String = initial?.text.toString()
            val finishSystem: String = finite?.text.toString()
            var startSystemInt = 0
            var finishSystemInt = 0
            var len: Int = num.length - 1
            var answer = 0
            var degree = 0
            var remains = 0
            if (num != "" && startSystem != "" && finishSystem != "") {
                startSystemInt = startSystem.toInt()
                finishSystemInt = finishSystem.toInt()
            } else
                textAnswer?.text = getString(R.string.error)
            while (len != -1) {
                if (num[len] == 'A')
                    remains = 10
                if (num[len] == 'B')
                    remains = 11
                if (num[len] == 'C')
                    remains = 12
                if (num[len] == 'D')
                    remains = 13
                if (num[len] == 'E')
                    remains = 14
                if (num[len] == 'F')
                    remains = 15
                if (num[len] == '1')
                    remains = 1
                if (num[len] == '2')
                    remains = 2
                if (num[len] == '3')
                    remains = 3
                if (num[len] == '4')
                    remains = 4
                if (num[len] == '5')
                    remains = 5
                if (num[len] == '6')
                    remains = 6
                if (num[len] == '7')
                    remains = 7
                if (num[len] == '8')
                    remains = 8
                if (num[len] == '9')
                    remains = 9
                if (num[len] == '0')
                    remains = 0
                answer += remains * startSystemInt.toDouble().pow(degree.toDouble()).toInt()
                len--
                degree++
            }
            var save = answer
            var result1 = ""
            while (save > 0) {
                remains = save % finishSystemInt
                if (remains == 10)
                    result1 += "A"
                if (remains == 11)
                    result1 += "B"
                if (remains == 12)
                    result1 += "C"
                if (remains == 13)
                    result1 += "D"
                if (remains == 14)
                    result1 += "E"
                if (remains == 15)
                    result1 += "F"
                if (remains == 1)
                    result1 += "1"
                if (remains == 2)
                    result1 += "2"
                if (remains == 3)
                    result1 += "3"
                if (remains == 4)
                    result1 += "4"
                if (remains == 5)
                    result1 += "5"
                if (remains == 6)
                    result1 += "6"
                if (remains == 7)
                    result1 += "7"
                if (remains == 8)
                    result1 += "8"
                if (remains == 9)
                    result1 += "9"
                if (remains == 0)
                    result1 += "0"
                save /= finishSystemInt
            }
            result1 = result1.reversed()
            if (answer == 0)
                result1 = "0"
            textAnswer?.text = result1
        }
    }
}