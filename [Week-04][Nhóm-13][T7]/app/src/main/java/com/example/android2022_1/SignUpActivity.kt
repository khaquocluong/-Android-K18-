package com.example.android2022_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android2022_1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val ds= DataStore(this)
        binding.btnSignUp.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            var password = binding.edtPassword.text.toString().trim()
            val student  = Student(email,password)
            if(!ds.checkPassword(password))
            {
                password = "wrong"
                viewModel.checkEmailAndPassword(email,password)
            }
            else
            {
                ds.addUser(email, password)
                viewModel.checkEmailAndPassword(email,password)
            }

        }
        listenerSuccessEvent()
        listenerErrorEvent()

    }
    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){isSuccess ->
            if (isSuccess){
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                val student  = Student(email,password)
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){errMsg ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("ERROR")
            dialog.setMessage(errMsg)
            dialog.show()
        }
    }
}