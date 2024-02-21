package com.example.pregnancyapp

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pregnancyapp.authentication_logic.AuthViewModel
import com.example.pregnancyapp.pages.CheckUpQuestions
import com.example.pregnancyapp.pages.MommyQuestionnairePage

import com.example.pregnancyapp.ui.theme.PregnancyAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authViewModel: AuthViewModel = viewModel()
            MainComposable(authViewModel = authViewModel)
        }
    }
}


