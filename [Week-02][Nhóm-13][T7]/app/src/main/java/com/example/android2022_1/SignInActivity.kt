package com.example.android2022_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btnOpenSignIn = findViewById<Button>(R.id.btn_login)
        btnOpenSignIn.setOnClickListener {
            val edtEmail = findViewById<EditText>(R.id.edt_email)
            val edtPassword = findViewById<EditText>(R.id.edt_password)
            val mail:String =  edtEmail.text.toString().trim()
            val password:String = edtPassword.text.toString().trim()
            val intent = Intent(this@SignInActivity, ProfileActivity::class.java)
            var email: String ="ronaldo@gmail.com"
            var pass:String="123456"
            if(mail.compareTo(email)==0 && password.compareTo(pass)==0) {
                startActivity(intent)
            }
        }
    }
}