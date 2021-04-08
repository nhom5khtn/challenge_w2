package com.example.android.firstweekchallenge

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginAcitvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            if (edtEmail.text.trim().toString().isNullOrEmpty()) {
                edtEmail.setError("enter email please!");
            }
            if (edtPassword.text.trim().toString().isNullOrEmpty()) {
                edtPassword.setError("enter password please!");
            }
            if (edtEmail.text.trim().toString() == "ronaldo@gmail.com" && edtPassword.text.trim().toString() == "123456") {
                Toast.makeText(applicationContext, "successful login!", Toast.LENGTH_SHORT).show()
                val b = Bundle()
                b.putParcelable("Account", Account(edtEmail.text.trim().toString()))
                intent.putExtras(b)
                startActivity(intent)
                finish()
            } else {
                val alertDialogBuilder = android.app.AlertDialog.Builder(this)
                alertDialogBuilder.setMessage("failed login!")
                alertDialogBuilder.setPositiveButton("OK") { dialog: DialogInterface,
                                                             which: Int ->
                    Toast.makeText(applicationContext, "please try again!", Toast.LENGTH_SHORT).show()
                }
                alertDialogBuilder.show()
            }
        }
    }
}
