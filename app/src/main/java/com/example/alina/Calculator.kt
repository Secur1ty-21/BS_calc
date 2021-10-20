package com.example.alina

import android.content.Intent
import android.os.Bundle
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
    private var answer1 : TextView? = null
    private var plusS : Button? = null
    private var minusS : Button? = null
    private var multiply : Button? = null
    private var division : Button? = null
    private var newSystem : EditText? = null
    private var converter : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        system1 = findViewById(R.id.system1)
        system2 = findViewById(R.id.system2)
        answer1 = findViewById(R.id.answer1)
        plusS = findViewById(R.id.plus)
        minusS = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        division = findViewById(R.id.division)
        newSystem = findViewById(R.id.new_system)
        converter = findViewById(R.id.converter)
        converter?.setOnClickListener {
            val intent = Intent(this, Converter::class.java)
            startActivity(intent)
            finish()
        }
        plusS?.setOnClickListener {
            val digit: String = number1?.text.toString()
            val digit2: String = number2?.text.toString()
            val systemS1: String = system1?.text.toString()
            val systemS2: String = system2?.text.toString()
            val newSystem1: String = newSystem?.text.toString()
            if (digit != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() <= 16 && systemS1.toInt() > 1 && systemS2.toInt() <= 16 && systemS2.toInt() > 1 && newSystem1.toInt() <= 16 && newSystem1.toInt() > 1) {
                    val answer = translateToTen(digit, systemS1.toInt()) + translateToTen(
                        digit2,
                        systemS2.toInt()

                    )
                    answer1?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    answer1?.text = getText(R.string.error)
            } else
                answer1?.text = getText(R.string.error)
        }
        minusS?.setOnClickListener {
            val digit: String = number1?.text.toString()
            val digit2: String = number2?.text.toString()
            val systemS1: String = system1?.text.toString()
            val systemS2: String = system2?.text.toString()
            val newSystem1: String = newSystem?.text.toString()
            if (digit != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() <= 16 && systemS1.toInt() > 1 && systemS2.toInt() <= 16 && systemS2.toInt() > 1 && newSystem1.toInt() <= 16 && newSystem1.toInt() > 1) {
                    val answer = translateToTen(digit, systemS1.toInt()) - translateToTen(
                        digit2,
                        systemS2.toInt()
                    )
                    answer1?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    answer1?.text = getText(R.string.error)
            } else
                answer1?.text = getText(R.string.error)
        }
        multiply?.setOnClickListener {
            val digit: String = number1?.text.toString()
            val digit2: String = number2?.text.toString()
            val systemS1: String = system1?.text.toString()
            val systemS2: String = system2?.text.toString()
            val newSystem1: String = newSystem?.text.toString()
            if (digit != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() <= 16 && systemS1.toInt() > 1 && systemS2.toInt() <= 16 && systemS2.toInt() > 1 && newSystem1.toInt() <= 16 && newSystem1.toInt() > 1) {
                    val answer = translateToTen(digit, systemS1.toInt()) * translateToTen(
                        digit2,
                        systemS2.toInt()
                    )
                    answer1?.text = translateToNew(answer, newSystem1.toInt())
                } else
                    answer1?.text = getText(R.string.error)
            } else
                answer1?.text = getText(R.string.error)
        }
        division?.setOnClickListener {
            val digit: String = number1?.text.toString()
            val digit2: String = number2?.text.toString()
            val systemS1: String = system1?.text.toString()
            val systemS2: String = system2?.text.toString()
            val newSystem1: String = newSystem?.text.toString()
            if (digit != "" && digit2 != "" && systemS1 != "" && systemS2 != "" && newSystem1 != "") {
                if (systemS1.toInt() <= 16 && systemS1.toInt() > 1 && systemS2.toInt() <= 16 && systemS2.toInt() > 1 && newSystem1.toInt() <= 16 && newSystem1.toInt() > 1) {
                    val a = translateToTen(digit2, systemS2.toInt())
                    if (a != 0) {
                        val answer = translateToTen(digit, systemS1.toInt()) / a
                        answer1?.text = translateToNew(answer, newSystem1.toInt())
                    } else
                        answer1?.text = getText(R.string.error1)
                } else
                    answer1?.text = getText(R.string.error)
            } else
                answer1?.text = getText(R.string.error)
        }
    }
    private fun translateToTen(digit : String, system: Int):Int{
        var answer = 0
        var len : Int = digit.length - 1
        var remains = 0
        var degree = 0
        while (len != -1) {
            if (digit[len] == 'A')
                remains = 10
            if (digit[len] == 'B')
                remains = 11
            if (digit[len] == 'C')
                remains = 12
            if (digit[len] == 'D')
                remains = 13
            if (digit[len] == 'E')
                remains = 14
            if (digit[len] == 'F')
                remains = 15
            if (digit[len] == '1')
                remains = 1
            if (digit[len] == '2')
                remains = 2
            if (digit[len] == '3')
                remains = 3
            if (digit[len] == '4')
                remains = 4
            if (digit[len] == '5')
                remains = 5
            if (digit[len] == '6')
                remains = 6
            if (digit[len] == '7')
                remains = 7
            if (digit[len] == '8')
                remains = 8
            if (digit[len] == '9')
                remains = 9
            if (digit[len] == '0')
                remains = 0
            answer += remains * system.toDouble().pow(degree.toDouble()).toInt()
            len--
            degree++
        }
        return answer
    }
    private fun translateToNew(digit : Int, newSystem: Int) : String {
        var save = digit
        var answer = ""
        var remains : Int
        var degree = 0
        while (save > 0){
            remains = save % newSystem
            if (remains == 10)
                answer += "A"
            if (remains == 11)
                answer += "B"
            if (remains == 12)
                answer += "C"
            if (remains == 13)
                answer += "D"
            if (remains == 14)
                answer += "E"
            if (remains == 15)
                answer += "F"
            if (remains == 1)
                answer += "1"
            if (remains == 2)
                answer += "2"
            if (remains == 3)
                answer += "3"
            if (remains == 4)
                answer += "4"
            if (remains == 5)
                answer += "5"
            if (remains == 6)
                answer += "6"
            if (remains == 7)
                answer += "7"
            if (remains == 8)
                answer += "8"
            if (remains == 9)
                answer += "9"
            if (remains == 0)
                answer += "0"
            save /= newSystem
            degree++
        }
        answer = answer.reversed()
        if (digit == 0)
            answer = "0"
        return answer
    }
}