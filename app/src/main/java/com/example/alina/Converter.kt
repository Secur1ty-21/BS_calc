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
    private var calculator : Button? = null
    private var settings : Button? = null
    private var textAnswer : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
        number = findViewById(R.id.numbers)
        initial = findViewById(R.id.initial)
        finite = findViewById(R.id.finite)
        buttonTranslate = findViewById(R.id.translate)
        textAnswer = findViewById(R.id.answer)
        calculator = findViewById(R.id.button6)
        settings = findViewById(R.id.setting2)
        settings?.setOnClickListener {
            val intent3 = Intent(this, Settings::class.java)
            startActivity(intent3)
        }
        calculator?.setOnClickListener {
            val intent2 = Intent(this, Calculator::class.java)
            startActivity(intent2)
        }
        buttonTranslate?.setOnClickListener {
            val num: String = number?.text.toString()
            val startSystem: String = initial?.text.toString()
            val finishSystem: String = finite?.text.toString()
            val startSystemInt : Int
            val finishSystemInt : Int
            var len: Int = num.length - 1
            var answer : Long = 0
            var degree = 0
            var remains = 0
            var sign = false
            if (num != "" && startSystem != "" && finishSystem != "") {
                startSystemInt = startSystem.toInt()
                finishSystemInt = finishSystem.toInt()
                if (startSystemInt in 2..16  && finishSystemInt in 2..16) {
                    while (len != -1) {
                        when {
                            num[len] == '-' -> sign = true
                            num[len] == 'A' -> remains = 10
                            num[len] == 'B' -> remains = 11
                            num[len] == 'C' -> remains = 12
                            num[len] == 'D' -> remains = 13
                            num[len] == 'E' -> remains = 14
                            num[len] == 'F' -> remains = 15
                            num[len] == '1' -> remains = 1
                            num[len] == '2' -> remains = 2
                            num[len] == '3' -> remains = 3
                            num[len] == '4' -> remains = 4
                            num[len] == '5' -> remains = 5
                            num[len] == '6' -> remains = 6
                            num[len] == '7' -> remains = 7
                            num[len] == '8' -> remains = 8
                            num[len] == '9' -> remains = 9
                            num[len] == '0' -> remains = 0
                        }
                        answer += remains * startSystemInt.toDouble().pow(degree.toDouble()).toLong()
                        len--
                        degree++
                    }
                    var save = answer
                    var result1 = ""
                    while (save > 0) {
                        remains = (save % finishSystemInt).toInt()
                        when (remains) {
                            10 -> result1 += "A"
                            11 -> result1 += "B"
                            12 -> result1 += "C"
                            13 -> result1 += "D"
                            14 -> result1 += "E"
                            15 -> result1 += "F"
                            1 -> result1 += "1"
                            2 -> result1 += "2"
                            3 -> result1 += "3"
                            4 -> result1 += "4"
                            5 -> result1 += "5"
                            6 -> result1 += "6"
                            7 -> result1 += "7"
                            8 -> result1 += "8"
                            9 -> result1 += "9"
                            0 -> result1 += "0"
                        }
                        save /= finishSystemInt
                    }
                    if (sign)
                        result1 += "-"
                    result1 = result1.reversed()
                    val zer0: Long = 0
                    if (answer == zer0)
                        result1 = "0"
                    textAnswer?.text = result1
                }
                else
                    textAnswer?.text = getString(R.string.system)
            } else
                textAnswer?.text = getString(R.string.error)
        }
    }
}