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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ButtonComponentCustomColor
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableTextCentered
import com.example.pregnancyapp.authentication_logic.AuthViewModel

@Composable
fun NumOfPregnancies(navController: NavController, authViewModel: AuthViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 40.dp,
                    bottom = 0.dp
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReusableTextCentered(
                text = "How many pregnancies have you had?",
                MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(100.dp))
            ReusableIcon(iconResourceId = R.drawable.pregnancies_num_logo,
                150, scaleSize = 1.6f, 0)

            Spacer(modifier = Modifier.height(90.dp))

            ButtonComponentCustomColor(
                value = "1",
                onClick = {
                    authViewModel.handleNumOfPregnanciesQuestion("1")
                    navController.navigate("questionfailedpregnancies")},
                Color(0xFFFFFCF6),
                Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "2",
                onClick = {
                    authViewModel.handleNumOfPregnanciesQuestion("2")
                    navController.navigate("questionfailedpregnancies")},
                Color(0xFFFFFCF6),
                Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "3",
                onClick = {
                    authViewModel.handleNumOfPregnanciesQuestion("3")
                    navController.navigate("questionfailedpregnancies")},
                Color(0xFFFFFCF6),
                Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentCustomColor(
                value = "more than 4",
                onClick = {
                    authViewModel.handleNumOfPregnanciesQuestion("<4")
                    navController.navigate("questionfailedpregnancies")},
                Color(0xFFFFFCF6),
                Color.Black)
        }
    }
}

