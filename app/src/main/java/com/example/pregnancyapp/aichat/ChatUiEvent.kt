package com.example.pregnancyapp.aichat

import android.graphics.Bitmap

/**
 * @author pregnancy app
 */
sealed class ChatUiEvent {
    data class UpdatePrompt(val newPrompt: String) : ChatUiEvent()
    data class SendPrompt(
        val prompt: String,
        val bitmap: Bitmap?
    ) : ChatUiEvent()
}