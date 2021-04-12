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

        //setContentView(R.layout.activity_login)

//        val edtEmail = findViewById<EditText>(R.id.edtEmail)
//        val edtPassword = findViewById<EditText>(R.id.edtPassword)
//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            if (binding.edtEmail.text.trim().toString().isNullOrEmpty()) {
                binding.edtEmail.setError("enter email please!");
            }
            if (binding.edtPassword.text.trim().toString().isNullOrEmpty()) {
                binding.edtPassword.setError("enter password please!");
            }
            if (binding.edtEmail.text.trim().toString() == DataStore.email && binding.edtPassword.text.trim().toString() == DataStore.password) {
                Toast.makeText(applicationContext, "successful login!", Toast.LENGTH_SHORT).show()
                val b = Bundle()
                b.putParcelable("Account", Account(binding.edtEmail.text.trim().toString()))
                intent.putExtras(b)
                startActivity(intent)
                finish()
            } else {
                val alertDialogBuilder = android.app.AlertDialog.Builder(this)
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
