package com.example.alina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var next : Button? = null
    private var calculator : Button? = null
    private var converter : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //next = findViewById(R.id.button1)
        calculator = findViewById(R.id.button2)
        converter = findViewById(R.id.button5)
        Log.d("MyLog", "1")
//        next?.setOnClickListener(
//            View.OnClickListener {
//                val intent = Intent("android.intent.action.New")
//                startActivity(intent)
//            }
//        )
        calculator?.setOnClickListener(
            View.OnClickListener {
                val intent2 = Intent("android.intent.action.Calculator")
                startActivity(intent2)
            }
        )
        converter?.setOnClickListener(
            View.OnClickListener {
                val intent3 = Intent("android.intent.action.Converter")
                startActivity(intent3)
            }
        )
    }

}