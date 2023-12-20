package com.example.medilab

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.medilab.contants.Constants
import com.example.medilab.helpers.ApiHelper
import com.example.medilab.helpers.PrefsHelper
import com.google.android.material.button.MaterialButton
import org.json.JSONArray
import org.json.JSONObject
import java.util.Calendar

class SignUpActivity3 : AppCompatActivity() {

  // Declarations: Having a variable name and data type with later initialization(assigning a value)
    private lateinit var buttonDatePicker: MaterialButton
    private lateinit var editTextDate: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up3)

        // Initialization
        buttonDatePicker = findViewById(R.id.btnDatePicker)
        editTextDate  = findViewById(R.id.edDate)

        buttonDatePicker.setOnClickListener {
            showDatePickerDialog()
        } // end listener

        // find the finish btn, get all data from prefs and register to the api using the api helper

        // getting the gender from the radio buttons
        val radioMale : RadioButton = findViewById(R.id.male)
        val radioFemale : RadioButton = findViewById(R.id.female)
        val radioOther : RadioButton = findViewById(R.id.other)

        var gender = ""
        if(radioMale.isChecked){
            gender = "Male"
            PrefsHelper.savePrefs(applicationContext, "gender", gender.toString())
        }
        if(radioFemale.isChecked){
            gender = "Female"
            PrefsHelper.savePrefs(applicationContext, "gender", gender.toString())
        }
        if(radioOther.isChecked){
            gender = "Other"
            PrefsHelper.savePrefs(applicationContext, "gender", gender.toString())
        }


        val finishBtn: MaterialButton = findViewById(R.id.finish)
        finishBtn.setOnClickListener {

            // get all data present on the prefs
            val surname = PrefsHelper.getPrefs(applicationContext, "surname")
            val others = PrefsHelper.getPrefs(applicationContext, "others")
            val email = PrefsHelper.getPrefs(applicationContext, "email")
            val phone = PrefsHelper.getPrefs(applicationContext, "phone")
            val password = PrefsHelper.getPrefs(applicationContext, "password")
            val confirm = PrefsHelper.getPrefs(applicationContext, "confirm")
            val dob = PrefsHelper.getPrefs(applicationContext, "dob")
            val gender = PrefsHelper.getPrefs(applicationContext, "gender")
            val location_id = "1"


            // call the API and Register
            val api = Constants.BASE_URL + "/member_signup"
            val body = JSONObject()
            body.put("surname", surname.toString())
            body.put("others", others.toString())
            body.put("email", email.toString())
            body.put("phone", phone.toString())
            body.put("password", password.toString())
            body.put("dob", dob.toString())
            body.put("gender", gender.toString())
            body.put("location_id", location_id.toString())

            val helper = ApiHelper(applicationContext)
            helper.post(api, body, object:ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(result: JSONObject?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })


        }

    } // end onCreate

    private fun showDatePickerDialog(){
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                editTextDate.setText(selectedDate)
                PrefsHelper.savePrefs(applicationContext, "dob", selectedDate.toString())
            },
            year, month, day)

        datePickerDialog.show()
    }
}