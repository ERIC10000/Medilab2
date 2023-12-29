package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val home_button: Button = findViewById(R.id.home)
        home_button.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }

        val signin_button: Button = findViewById(R.id.signin_button)
        signin_button.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        val signup_button: Button = findViewById(R.id.signup)
        signup_button.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }


        val bottom_sheet : FrameLayout = findViewById(R.id.bottom_sheet)
        BottomSheetBehavior.from(bottom_sheet).apply {
            peekHeight = 230
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

    }
}