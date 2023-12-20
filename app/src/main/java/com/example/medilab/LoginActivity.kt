package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.medilab.contants.Constants
import com.example.medilab.helpers.ApiHelper
import com.google.android.material.button.MaterialButton
import org.json.JSONArray
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            val editTextSurname: EditText = findViewById(R.id.edLoginSurname)
            val editTextPassword: EditText = findViewById(R.id.edPassword)

            val surname = editTextSurname.text
            val password = editTextPassword.text

        val loginBtn: MaterialButton = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {

            val api: String = Constants.BASE_URL + "/member_signin"
            val body = JSONObject()
            body.put("surname", surname.toString())
            body.put("password", password.toString())

            val helper = ApiHelper(applicationContext)
            helper.post(api, body, object : ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(result: JSONObject?) {
                    // successful
                    if(result!!.has("refresh_token")){

                        Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}