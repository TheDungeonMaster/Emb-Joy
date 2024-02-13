package com.example.pregnancyapp.login_register

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColor
import com.example.pregnancyapp.login_register.screens.SignUpScreen

@Composable
fun LoginPage(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = androidx.compose.ui.graphics.Color.White
    ) {
        SignUpScreen()
    }
}

