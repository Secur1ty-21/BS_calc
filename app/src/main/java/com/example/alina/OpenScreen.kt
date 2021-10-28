package com.example.alina

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OpenScreen : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_openscreen)
        Thread{
            Thread.sleep(3000)
            startActivity(Intent(this, Converter::class.java))
            finish()
        }.start()
    }
}
