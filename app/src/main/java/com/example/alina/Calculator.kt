package com.example.alina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class Calculator : AppCompatActivity(){
    private var number1 : EditText? = null
    private var number2 : EditText? = null
    private var system1 : EditText? = null
    private var system2 : EditText? = null
    private var newSystem : EditText? = null
    private var plusS : Button? = null
    private var minusS : Button? = null
    private var multiply : Button? = null
    private var division : Button? = null
    private var settings : Button? = null
    private var converter : Button? = null
    private var result : TextView? = null
    private val zer0 : Long = 0
    private var sign : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        system1 = findViewById(R.id.system1)
        system2 = findViewById(R.id.system2)
        result = findViewById(R.id.answer1)
        plusS = findViewById(R.id.plus)
        minusS = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        division = findViewById(R.id.division)
        newSystem = findViewById(R.id.new_system)
        converter = findViewById(R.id.converter)
        settings =findViewById(R.id.settings1)
        var digit1: String
        var digit2: String
        var systemS1: String
        var systemS2: String
        var newSystem1: String
        settings?.setOnClickListener {
            val intent3 = Intent(this, Settings::class.java)
            startActivity(intent3)
        }
        converter?.setOnClickListener {
            val intent = Intent(this, Converter::class.java)
            startActivity(intent)
        }
        plusS?.setOnClickListener {
            digit1 = number1?.text.toString()
            digit2 = number2?.text.toString()
            systemS1 = system1?.text.toString()
            systemS2 = system2?.text.toString()
            newSystem1 = newSystem?.text.toString()
            if (digit1 != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() in 2..16  && newSystem1.toInt() in 2..16) {
                    val answer : Long = translateToTen(digit1, systemS1.toInt()) + translateToTen(digit2, systemS2.toInt())
                    result?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    result?.text = getText(R.string.system)
            } else
                result?.text = getText(R.string.digit)
        }
        minusS?.setOnClickListener {
            digit1 = number1?.text.toString()
            digit2 = number2?.text.toString()
            systemS1 = system1?.text.toString()
            systemS2 = system2?.text.toString()
            newSystem1 = newSystem?.text.toString()
            if (digit1 != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() in 2..16  && newSystem1.toInt() in 2..16) {
                    val answer : Long = translateToTen(digit1, systemS1.toInt()) - translateToTen(digit2, systemS2.toInt())
                    Log.d("MyLog", "$answer")
                    result?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    result?.text = getText(R.string.system)
            } else
                result?.text = getText(R.string.digit)
        }
        multiply?.setOnClickListener {
            digit1 = number1?.text.toString()
            digit2 = number2?.text.toString()
            systemS1 = system1?.text.toString()
            systemS2 = system2?.text.toString()
            newSystem1 = newSystem?.text.toString()
            if (digit1 != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() in 2..16  && newSystem1.toInt() in 2..16) {
                    val answer : Long = translateToTen(digit1, systemS1.toInt()) * translateToTen(digit2, systemS2.toInt())
                    result?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    result?.text = getText(R.string.system)
            } else
                result?.text = getText(R.string.digit)
        }
        division?.setOnClickListener {
            digit1 = number1?.text.toString()
            digit2 = number2?.text.toString()
            systemS1 = system1?.text.toString()
            systemS2 = system2?.text.toString()
            newSystem1 = newSystem?.text.toString()
            if (digit1 != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() in 2..16  && newSystem1.toInt() in 2..16) {
                    val a : Long = translateToTen(digit2, systemS2.toInt())
                    if (a != zer0) {
                        val answer : Long = translateToTen(digit1, systemS1.toInt()) / a
                        result?.text = translateToNew(answer, newSystem1.toInt())
                    } else
                        result?.text = getText(R.string.error1)
                } else
                    result?.text = getText(R.string.system)
            } else
                result?.text = getText(R.string.digit)
        }
    }
    private fun translateToTen(digit : String, system: Int):Long{
        var answer : Long = 0
        var len : Int = digit.length - 1
        var remains = 0
        var degree = 0
        while (len != -1) {
            when {
                digit[len] == '-' -> sign = true
                digit[len] == 'A' -> remains = 10
                digit[len] == 'B' -> remains = 11
                digit[len] == 'C' -> remains = 12
                digit[len] == 'D' -> remains = 13
                digit[len] == 'E' -> remains = 14
                digit[len] == 'F' -> remains = 15
                digit[len] == '1' -> remains = 1
                digit[len] == '2' -> remains = 2
                digit[len] == '3' -> remains = 3
                digit[len] == '4' -> remains = 4
                digit[len] == '5' -> remains = 5
                digit[len] == '6' -> remains = 6
                digit[len] == '7' -> remains = 7
                digit[len] == '8' -> remains = 8
                digit[len] == '9' -> remains = 9
                digit[len] == '0' -> remains = 0
            }
            answer += remains * system.toDouble().pow(degree.toDouble()).toLong()
            len--
            degree++
        }
        if (sign)
            answer *= -1
        sign = false
        return answer
    }
    private fun translateToNew(digit : Long, newSystem: Int) : String {
        var save = digit
        var answer = ""
        var remains : Int
        var degree = 0
        if (digit < 0)
        {
            save *= -1
            sign = true
        }
        while (save > 0){
            remains = (save % newSystem).toInt()
            when (remains) {
                10 -> answer += "A"
                11 -> answer += "B"
                12 -> answer += "C"
                13 -> answer += "D"
                14 -> answer += "E"
                15 -> answer += "F"
                1 -> answer += "1"
                2 -> answer += "2"
                3 -> answer += "3"
                4 -> answer += "4"
                5 -> answer += "5"
                6 -> answer += "6"
                7 -> answer += "7"
                8 -> answer += "8"
                9 -> answer += "9"
                0 -> answer += "0"
            }
            save /= newSystem
            degree++
        }
        if (sign)
        {
            answer += "-"
            sign = false
        }
        answer = answer.reversed()
        if (digit == zer0)
            answer = "0"
        return answer
    }
}