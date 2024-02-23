package com.example.pregnancyapp.authentication_logic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Journal (
    @PrimaryKey(autoGenerate = false)
    val date: String,
    val email: String,
    val nameSurname: String? = "N/A",
    val dayOfPregnancy: String? = "N/A",
    val weight: String? = "N/A",
    val height: String? = "N/A",
    val bloodPressure: String? = "N/A",
    val bloodSugar: String? = "N/A",
    val swellings: Boolean = false,
    val bleeding: Boolean = false


){
}