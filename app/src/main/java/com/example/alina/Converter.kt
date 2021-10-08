package com.example.alina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
                //startActivity(intent4)
                finish()
            }
        )

        buttonTranslate?.setOnClickListener(
            View.OnClickListener {

                var num : String = number?.text.toString()
                var startSystem : String = initial?.text.toString()
                var finishSystem : String = finite?.text.toString()

                var remains: Int = 0
                if (num != "" && startSystem != "" && finishSystem != "") {
                    var startSystemInt: Int = startSystem.toInt()
                    Log.d("MyLog", "$startSystemInt")
                    var finishSystemInt: Int = finishSystem.toInt()
                    Log.d("MyLog", "$finishSystemInt")
                }
                else
                    textAnswer?.text = "Error Input"
            }
        )
    }
}