package com.example.android.firstweekchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.view.View
import android.widget.TextView
import android.view.ViewTreeObserver.OnPreDrawListener
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("WelcomeActivity", "welcome activity - on start")
        setContentView(R.layout.activity_welcome)

        val textDescription1 = findViewById<TextView>(R.id.tvWelcomeTo)
        val textDescription2 = findViewById<TextView>(R.id.tvFoodHub)
        val textDescription3 = findViewById<TextView>(R.id.tvSlogan)
        val epButton = findViewById<Button>(R.id.epButton)
        val fbButton = findViewById<Button>(R.id.fbButton)
        val ggButton = findViewById<Button>(R.id.ggButton)
        val signInButton = findViewById<ImageButton>(R.id.signInButton)
        val textDescription4 = findViewById<TextView>(R.id.tvQuestion)


        epButton.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("WelcomeActivity", "welcome activity - on start")
    }

    override fun onResume() {
        super.onResume()
        Log.e("WelcomeActivity", "welcome activity - on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("WelcomeActivity", "welcome activity - on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("WelcomeActivity", "welcome activity - on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("WelcomeActivity", "welcome activity - on Destroy")
    }
}