package com.example.pregnancyapp.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pregnancyapp.ButtonComponentCustomColor
import com.example.pregnancyapp.ReusableTextCentered
import com.example.pregnancyapp.authentication_logic.AuthViewModel

@Composable
fun PreExistingMedConditions(navController: NavController, authViewModel: AuthViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 10.dp,
                    bottom = 0.dp
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReusableTextCentered(
                text = "Do you have any pre-existing medical conditions?",
                MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            val selectedConditions = remember { mutableStateListOf<String>() }

            // ButtonComponentCustomColor for each condition with onClick handling
            ButtonComponentCustomColor(
                value = "Diabetes",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("diabetes")
                          },
                Color(0xFFFFFCF6),
                Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "High Blood Pressure",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("highBloodPressure")
                          },
                Color(0xFFFFFCF6),
                Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Asthma",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("asthma")
                          },
                Color(0xFFFFFCF6),
                Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Fertility Issues",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("fertilityIssues")
                },
                Color(0xFFFFFCF6),
                Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Mental Health Conditions",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("mentalHealthConditions")
                },
                Color(0xFFFFFCF6),
                Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Obesity",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("obesity") },
                Color(0xFFFFFCF6),
                Color.Black

            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Other",
                onClick = {
                    authViewModel.handleSelectedMedicalConditions("other") },
                Color(0xFFFFFCF6),
                Color.Black

            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "Submit",
                onClick = {
                    navController.navigate("welcome")
                },
                Color(0xFF75BFCB),
                Color.Black
            )
        }
    }
}

