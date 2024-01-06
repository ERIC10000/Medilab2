package com.example.medilab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.medilab.helpers.PrefsHelper
import com.google.android.material.button.MaterialButton

class SingleLabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_lab)

        // find the views in the single lab activity
        val tvTestName : TextView = findViewById(R.id.test_name)
        val tvTestCost : TextView = findViewById(R.id.test_cost)
        val tvTestAvailability : TextView = findViewById(R.id.availability)
        val tvTestDesc : TextView = findViewById(R.id.test_description)

        // bind data from the Preference
        val test_name = PrefsHelper.getPrefs(applicationContext, "test_name")
        tvTestName.text = test_name

        val test_cost = PrefsHelper.getPrefs(applicationContext, "test_cost")
        tvTestCost.text = "KES " + test_cost

        // bind the 2 remaining then run app

        val test_availability = PrefsHelper.getPrefs(applicationContext, "availability")
        tvTestAvailability.text = "Test Avaialabity: " + test_availability

        val test_desc = PrefsHelper.getPrefs(applicationContext, "test_description")
        tvTestDesc.text = test_desc


        // fin the book btn and proceed to book
        val btnBook : MaterialButton = findViewById(R.id.btnBook)
        btnBook.setOnClickListener {
            val intent = Intent(applicationContext, BookActivity::class.java)
            startActivity(intent)
        }
    }
}