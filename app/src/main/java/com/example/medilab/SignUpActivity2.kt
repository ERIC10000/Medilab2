package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class SignUpActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val next2: MaterialButton = findViewById(R.id.next2)
        next2.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity3::class.java)
            startActivity(intent)
        }
    }
}