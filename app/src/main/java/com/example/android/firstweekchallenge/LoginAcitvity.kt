package com.example.android.firstweekchallenge

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.firstweekchallenge.databinding.ActivityLoginBinding

class LoginAcitvity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val intentSignUpActivity = Intent(this, SignUpActivity::class.java)
        val intentProfileActivity = Intent(this, ProfileActivity::class.java)

        binding.btnSignUp.setOnClickListener {
            startActivity(intentSignUpActivity)
            finish()
        }
        binding.apply {  btnLogin.setOnClickListener {
            if (edtEmail.text.trim().toString().isNullOrEmpty()) {
                edtEmail.setError("enter email please!");
            }
            if (edtPassword.text.trim().toString().isNullOrEmpty()) {
                binding.edtPassword.setError("enter password please!");
            }
            if (binding.edtEmail.text.trim().toString() == DataStore.email && binding.edtPassword.text.trim().toString() == DataStore.password) {
                Toast.makeText(applicationContext, "successful login!", Toast.LENGTH_SHORT).show()
                startActivity(intentProfileActivity)
                finish()
            } else {
                val alertDialogBuilder = android.app.AlertDialog.Builder(this@LoginAcitvity)
                alertDialogBuilder.setMessage("failed login!")
                alertDialogBuilder.setPositiveButton("OK") {
                        dialog: DialogInterface,
                        which: Int
                    ->
                    Toast.makeText(applicationContext, "please try again!", Toast.LENGTH_SHORT)
                        .show()
                }
                alertDialogBuilder.show()
            }
            }
        }
    }
}
