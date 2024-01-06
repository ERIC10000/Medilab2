package com.example.medilab.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medilab.BookActivity
import com.example.medilab.LabTestsActivity
import com.example.medilab.R
import com.example.medilab.SingleLabActivity
import com.example.medilab.helpers.PrefsHelper
import com.example.medilab.models.Lab
import com.example.medilab.models.LabTest
import com.google.android.material.textview.MaterialTextView

class LabTestAdapter(var context: Context) :
    RecyclerView.Adapter<LabTestAdapter.ViewHolder>() {

    var itemList: List<LabTest> = listOf() // empty by default

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    // 1. onCreateViewHolder -> Used to call the single item file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_lab_test, parent, false)
        return ViewHolder(view)
    }

    // 2. getItemCount -> Return the number of items on the recycler View
    override fun getItemCount(): Int {
        return itemList.size
    }


    // 3. onBindViewHolder -> Used to bind(attach) data to the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // find the views from single item

        val tvLabTestName: MaterialTextView = holder.itemView.findViewById(R.id.test_name)
        val tvTestCost: MaterialTextView = holder.itemView.findViewById(R.id.test_cost)

        // bind data to the views
        val labTestModel = itemList[position]

        tvLabTestName.text = labTestModel.test_name
        tvTestCost.text ="KES " +  labTestModel.test_cost


        holder.itemView.setOnClickListener {
            val test_id = labTestModel.test_id
            val lab_id = labTestModel.lab_id
            val test_name = labTestModel.test_name
            val test_description = labTestModel.test_description
            val test_cost = labTestModel.test_cost
            val test_discount = labTestModel.test_discount
            val availability = labTestModel.Availability
            val more_info = labTestModel.more_info
            val reg_date = labTestModel.reg_date

            PrefsHelper.savePrefs(context, "test_id", test_id.toString() )
            PrefsHelper.savePrefs(context, "lab_id", lab_id.toString() )
            PrefsHelper.savePrefs(context, "test_name", test_name.toString() )
            PrefsHelper.savePrefs(context, "test_description", test_description.toString() )
            PrefsHelper.savePrefs(context, "test_cost", test_cost.toString() )
            PrefsHelper.savePrefs(context, "test_discount", test_discount.toString() )
            PrefsHelper.savePrefs(context, "availability", availability.toString() )
            PrefsHelper.savePrefs(context, "more_info", more_info.toString() )
            PrefsHelper.savePrefs(context, "reg_date", reg_date.toString() )

            val intent = Intent(context, SingleLabActivity
            ::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }

    }

    fun setListItems(data: List<LabTest>){
        itemList = data
        notifyDataSetChanged()
    }
}