package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.medilab.helpers.PrefsHelper
import com.google.android.material.button.MaterialButton

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // get data from the 3 editText

        val editTextSurname : EditText = findViewById(R.id.edSurname)
        val editTextOthers : EditText = findViewById(R.id.edOthers)
        val editTextEmail: EditText = findViewById(R.id.edEmail)

        // extract data
        val surname = editTextSurname.text
        val others = editTextOthers.text
        val email = editTextEmail.text




        val next1: MaterialButton = findViewById(R.id.next1)
        next1.setOnClickListener {

            // surname, others and email saved to the preference then move to screen 2

            PrefsHelper.savePrefs(applicationContext, "surname", surname.toString())
            PrefsHelper.savePrefs(applicationContext, "others", others.toString())
            PrefsHelper.savePrefs(applicationContext, "email", email.toString())

            val intent = Intent(applicationContext, SignUpActivity2::class.java)
            startActivity(intent)
        }


    }
}