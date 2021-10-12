package com.example.alina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.pow

class Converter : AppCompatActivity() {
    private var number : EditText? = null
    private var initial : EditText? = null
    private var finite : EditText? = null
    private var buttonTranslate : Button? = null
    private var textAnswer : TextView? = null
    private var buttonBack : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
        number = findViewById(R.id.number)
        initial = findViewById(R.id.initial)
        finite = findViewById(R.id.finite)
        buttonTranslate = findViewById(R.id.translate)
        textAnswer = findViewById(R.id.answer)
        buttonBack = findViewById(R.id.back)
        buttonBack?.setOnClickListener(
            View.OnClickListener {
                val intent4 = Intent("android.intent.category.MainActivity")
                finish()
            }
        )

        buttonTranslate?.setOnClickListener(
            View.OnClickListener {

                var num : String = number?.text.toString()
                var startSystem : String = initial?.text.toString()
                var finishSystem : String = finite?.text.toString()
                var startSystemInt : Int = 0
                var finishSystemInt: Int = 0
                var len : Int = num.length - 1
                var answer : Int = 0
                var degree : Int = 0
                var result : Int = 0
                var e : Int = 0
                var clone : Int = 0

                var remains: Int = 0
                if (num != "" && startSystem != "" && finishSystem != "") {
                    startSystemInt  = startSystem.toInt()
                    Log.d("MyLog", "$startSystemInt")
                    finishSystemInt = finishSystem.toInt()
                    Log.d("MyLog", "$finishSystemInt")

                }
                else
                    textAnswer?.text = "Error input"


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
                    answer += remains * pow(startSystemInt.toDouble(), degree.toDouble()).toInt()
                    len--
                    degree++

                }

                var save = 0


                clone = 0
                while (answer > 0){
                    remains = answer % finishSystemInt
                    save += remains * pow(10.0, clone.toDouble()).toInt()
                    answer /= finishSystemInt
                    clone++
                }
                //Toast.makeText(this, "$answer", Toast.LENGTH_SHORT).show()
                textAnswer?.text = save.toString()
            }
        )
    }
}