package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val next1: MaterialButton = findViewById(R.id.next1)
        next1.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity2::class.java)
            startActivity(intent)
        }


    }
}