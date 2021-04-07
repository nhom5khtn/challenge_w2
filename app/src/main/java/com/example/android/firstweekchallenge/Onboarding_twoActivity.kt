package com.example.android.firstweekchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class Onboarding_twoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        val btn1 = findViewById<ImageButton>(R.id.btn1)
        val vi1 = findViewById<View>(R.id.view1)
        val vi2 = findViewById<View>(R.id.view2)
        val t1 = findViewById<TextView>(R.id.textView4)
        val t2 = findViewById<TextView>(R.id.textView5)

        btn1.setOnClickListener(){
            val intent = Intent(this@Onboarding_twoActivity, Onboarding_threeActivity::class.java)
            startActivity(intent)
        }
    }
}