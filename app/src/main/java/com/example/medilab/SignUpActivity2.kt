package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.medilab.helpers.PrefsHelper
import com.google.android.material.button.MaterialButton

class SignUpActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        // get data from the 3 editText

        val editTextPhone : EditText = findViewById(R.id.edPhone)
        val editTextPassword : EditText = findViewById(R.id.edPassword)
        val editTextConfirm: EditText = findViewById(R.id.edConfirm)

        // extract data
        val phone = editTextPhone.text
        val password = editTextPassword.text
        val confirm = editTextConfirm.text


        val next2: MaterialButton = findViewById(R.id.next2)
        next2.setOnClickListener {

            PrefsHelper.savePrefs(applicationContext, "phone", phone.toString())
            PrefsHelper.savePrefs(applicationContext, "password", password.toString())
            PrefsHelper.savePrefs(applicationContext, "confirm", confirm.toString())

            val intent = Intent(applicationContext, SignUpActivity3::class.java)
            startActivity(intent)
        }
    }
}