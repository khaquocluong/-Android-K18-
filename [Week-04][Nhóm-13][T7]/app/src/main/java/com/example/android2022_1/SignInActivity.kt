package com.example.android2022_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android2022_1.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("ERROR")
            dialog.setMessage(errMsg)
            dialog.show()
            //Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()

        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                val intent = Intent(this@SignInActivity, LinearLayoutShow::class.java)

                val bundle = Bundle()
                bundle.putParcelable(constant.KEY_STUDENT, Student(email,password))
                intent.putExtras(bundle)

                val ds= DataStore(this)
                var returnDs= ds.getUser(email, password)

                if (returnDs) {
                    startActivity(intent)
                    //}
                }
            }
        }
    }
}