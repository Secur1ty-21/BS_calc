package com.example.alina

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OpenScreen : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_openscreen)
        var time = 0
        Thread{
            while (time < 3){
                time++
                Thread.sleep(1000)
            }
            val intent = Intent("android.intent.action.MainActivity")
            startActivity(intent)
            finish()
        }.start()

    }
}
