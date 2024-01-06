package com.example.medilab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medilab.adapters.LabAdapter
import com.example.medilab.adapters.LabTestAdapter
import com.example.medilab.contants.Constants
import com.example.medilab.helpers.ApiHelper
import com.example.medilab.helpers.PrefsHelper
import com.example.medilab.models.Lab
import com.example.medilab.models.LabTest
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject

class LabTestsActivity : AppCompatActivity() {

    // late initializations
    lateinit var itemList : List<LabTest>
    lateinit var recyclerView: RecyclerView
    lateinit var labTestAdapter: LabTestAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_tests)

        recyclerView = findViewById(R.id.recyclerView)
        labTestAdapter = LabTestAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        fetchLabTests()

    } // end onCreate()

    fun fetchLabTests(){
        val api = Constants.BASE_URL + "/lab_tests"
        val lab_id = PrefsHelper.getPrefs(applicationContext, "lab_id")
        val body = JSONObject()
        body.put("lab_id", lab_id.toString())


        val helper = ApiHelper(applicationContext)

        helper.post(api, body,  object : ApiHelper.CallBack{
            override fun onSuccess(result: JSONArray?) {
                val gson = GsonBuilder().create()
                itemList = gson.fromJson(result.toString(), Array<LabTest>::class.java).toList()
                labTestAdapter.setListItems(itemList)
                recyclerView.adapter = labTestAdapter
            }

            override fun onSuccess(result: JSONObject?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(result: String?) {
                Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}