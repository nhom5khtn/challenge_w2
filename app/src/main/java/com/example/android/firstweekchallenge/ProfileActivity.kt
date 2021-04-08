package com.example.android.firstweekchallenge

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity



class ProfileActivity : AppCompatActivity(), PhoneDialog.OnFragmentManager, FullNameDialog.OnFragmentManager {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtFullName = findViewById<EditText>(R.id.edtFullName)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)

        val bundle: Bundle? = intent.extras
        bundle?.let{
            bundle.apply {
                //Parcelable Data
                val account = it.getParcelable<Account>("Account")
                if (account != null) {
                    edtEmail.setText(account.email)
                }
            }
        }
    }

    fun withEdtPhone(view: View) {
        PhoneDialog().show(supportFragmentManager, "PhoneDialog")
    }
    fun withEdtFullName(view: View) {
        FullNameDialog().show(supportFragmentManager, "FullNameDialog")
    }

    override fun onPhoneSelected(phone: String) {
        Log.e("ProfileActivity", "phone: $phone")
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        edtPhone.setText(phone)
    }

    override fun onFullNameSelected(fullName: String) {
        Log.e("ProfileActivity", "fullName $fullName")
        val edtFullName = findViewById<EditText>(R.id.edtFullName)
        edtFullName.setText(fullName)
    }

}