package com.example.android.firstweekchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class Onboarding_threeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)

        val btn2 = findViewById<ImageButton>(R.id.btn1)
        val vi1 = findViewById<View>(R.id.view1)
        val vi2 = findViewById<View>(R.id.view2)
        val txt1 = findViewById<TextView>(R.id.textView4)
        val txt2 = findViewById<TextView>(R.id.textView5)

        btn2.setOnClickListener(){
            val intent = Intent(this@Onboarding_threeActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }


    }
}