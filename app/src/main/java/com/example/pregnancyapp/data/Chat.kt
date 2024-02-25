package com.example.pregnancyapp.data


import android.graphics.Bitmap

/**
 * @author pregnancy app
 */
data class Chat (
    val prompt: String,
    val bitmap: Bitmap?,
    val isFromUser: Boolean
)