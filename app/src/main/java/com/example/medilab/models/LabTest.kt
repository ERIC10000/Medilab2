package com.example.medilab.models

data class LabTest(
    val test_id: String,
    val lab_id: String,
    val test_name: String,
    val test_description: String,
    val test_cost: String,
    val test_discount: String,
    val Availability: String,
    val more_info: String,
    val reg_date: String
)
