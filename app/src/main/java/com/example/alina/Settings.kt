package com.example.alina

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Settings : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val exit : Button = findViewById(R.id.exit)
        exit.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }
    }
}
