package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.xml.sax.HandlerBase

class SplashTheme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            var intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        },1000)

    }

}