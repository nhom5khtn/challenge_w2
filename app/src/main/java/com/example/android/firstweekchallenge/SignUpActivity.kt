package com.example.android.firstweekchallenge

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.android.firstweekchallenge.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        val intent = Intent(this, LoginAcitvity::class.java)

        binding.apply {
            btnSignUp.setOnClickListener {

            if (edtFullName.text.trim().toString().isNullOrEmpty()) {
                edtFullName.setError("enter full name please!");
            }
            if (edtEmail.text.trim().toString().isNullOrEmpty()) {
                edtEmail.setError("enter email please!");
            }
            if (edtPassword.text.trim().toString().isNullOrEmpty()) {
                edtPassword.setError("enter password please!");
            }

            if (edtFullName.text.trim().toString() != "" && edtEmail.text.trim().toString() != "" && edtPassword.text.trim().toString() != ""){

                DataStore.fullName = edtFullName.text.trim().toString();
                DataStore.email = edtEmail.text.trim().toString();
                DataStore.password = edtPassword.text.trim().toString();

                Toast.makeText(applicationContext, "successful sign up!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }else{
                val alertDialogBuilder = android.app.AlertDialog.Builder(this@SignUpActivity)
                alertDialogBuilder.setMessage("failed sign up!")
                alertDialogBuilder.setPositiveButton("OK") { dialog: DialogInterface,
                                                             which: Int ->
                    Toast.makeText(applicationContext, "please try again!", Toast.LENGTH_SHORT).show()
                }
                alertDialogBuilder.show()
            }
        }}

    }

//    override fun onStart() {
//        super.onStart()
//        Log.e("SignUpActivity", "sign up activity - on start")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.e("SignUpActivity", "sign up activity - on Resume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.e("SignUpActivity", "sign up activity - on Pause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.e("SignUpActivity", "sign up activity - on Stop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.e("SignUpActivity", "sign up activity - on Destroy")
//    }
}