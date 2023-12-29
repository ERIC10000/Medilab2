package com.example.medilab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medilab.adapters.LabAdapter
import com.example.medilab.contants.Constants
import com.example.medilab.helpers.ApiHelper
import com.example.medilab.models.Lab
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment() {


    lateinit var itemList: List<Lab>
    lateinit var recyclerView: RecyclerView
    lateinit var labAdapter: LabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        labAdapter = LabAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(context)
        fetchLabs()

        return view

    } // end onCreateView



    fun fetchLabs(){
        val api = Constants.BASE_URL + "/laboratories"
        val helper = ApiHelper(requireContext())
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: JSONArray?) {
                val gson = GsonBuilder().create()
                itemList = gson.fromJson(result.toString(), Array<Lab>::class.java).toList()
                labAdapter.setListItems(itemList)
                recyclerView.adapter = labAdapter
            }

            override fun onSuccess(result: JSONObject?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(result: String?) {
                Toast.makeText(requireContext(), "${result.toString()}", Toast.LENGTH_SHORT).show()
            }
        })
    }

} // end HomeFragment