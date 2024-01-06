package com.example.medilab.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medilab.LabTestsActivity
import com.example.medilab.R
import com.example.medilab.helpers.PrefsHelper
import com.example.medilab.models.Lab
import com.google.android.material.textview.MaterialTextView

class LabAdapter(var context: Context) :
    RecyclerView.Adapter<LabAdapter.ViewHolder>() {

        var itemList: List<Lab> = listOf() // empty by default

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    // 1. onCreateViewHolder -> Used to call the single item file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_lab, parent, false)
        return ViewHolder(view)
    }

    // 2. getItemCount -> Return the number of items on the recycler View
    override fun getItemCount(): Int {
        return itemList.size
    }


    // 3. onBindViewHolder -> Used to bind(attach) data to the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // find the views from single item

        val tvLabName: MaterialTextView = holder.itemView.findViewById(R.id.lab_name)
        val tvLabPermit: MaterialTextView = holder.itemView.findViewById(R.id.permit_id)

        // bind data to the views
        val labModel = itemList[position]

        tvLabName.text = labModel.lab_name
        tvLabPermit.text = "Permit Serial: " +  labModel.permit_id


        holder.itemView.setOnClickListener {
            val lab_id = labModel.lab_id
            PrefsHelper.savePrefs(context, "lab_id", lab_id.toString() )
            val intent = Intent(context, LabTestsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }

    }

    fun setListItems(data: List<Lab>){
        itemList = data
        notifyDataSetChanged()
    }
}