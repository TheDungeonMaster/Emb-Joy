package com.example.pregnancyapp.aichat


import android.graphics.Bitmap
import com.example.pregnancyapp.data.Chat

/**
 * @author pregnancy app
 */
data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)