package com.example.android2022_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android2022_1.databinding.ActivityMenuOptionBinding

class MenuOptionLayout : AppCompatActivity() {
    private lateinit var binding: ActivityMenuOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_option)
        binding.btnLinear.setOnClickListener {
            val intent = Intent(this@MenuOptionLayout, LinearLayoutShow::class.java)
            startActivity(intent)
        }
        binding.btnGidView.setOnClickListener {
            val intent = Intent(this@MenuOptionLayout, GidLayoutShow::class.java)
            startActivity(intent)
        }
    }
}