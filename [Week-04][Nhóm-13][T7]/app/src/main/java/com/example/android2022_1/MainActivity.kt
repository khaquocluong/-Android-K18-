package com.example.android2022_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOpenWelcome = findViewById<Button>(R.id.btn_open_welcome)
        btnOpenWelcome.setOnClickListener {
            val intent = Intent (this@MainActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}