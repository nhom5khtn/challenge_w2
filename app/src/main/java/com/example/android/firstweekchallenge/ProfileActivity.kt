package com.example.android.firstweekchallenge

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.firstweekchallenge.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity(), PhoneDialog.OnFragmentManager, FullNameDialog.OnFragmentManager {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

    }

    fun withEdtPhone(view: View) {
        PhoneDialog().show(supportFragmentManager, "PhoneDialog")
    }
    fun withEdtFullName(view: View) {
        FullNameDialog().show(supportFragmentManager, "FullNameDialog")
    }

    override fun onPhoneSelected(phone: String) {
        Log.e("ProfileActivity", "phone: $phone")
        binding.edtPhone.setText(phone)
    }

    override fun onFullNameSelected(fullName: String) {
        Log.e("ProfileActivity", "fullName $fullName")
        binding.edtFullName.setText(fullName)
    }

}