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
import com.example.pregnancyapp.R
import com.example.pregnancyapp.login_register.components.ButtonComponentCustomColor
import com.example.pregnancyapp.login_register.components.ReusableIcon
import com.example.pregnancyapp.login_register.components.ReusableTextCentered

@Composable
fun FailPregnancyQuestion() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 100.dp,
                    bottom = 0.dp
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReusableTextCentered(
                text = "Have you had any failed pregnancies?",
                MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(100.dp))
            ReusableIcon(iconResourceId = R.drawable.failed_pregnancies_logo,
                150, scaleSize = 1.6f, 0)

            Spacer(modifier = Modifier.height(90.dp))

            ButtonComponentCustomColor(value = "Yes", onClick = { /* your action
             for
            "Yes" button */ }, Color(0xFF75BFCB), Color.White)

            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponentCustomColor(value = "No", onClick = { /* your action
            for "No"
             button */ }, Color(0xFFFFFCF6), Color.Black)
        }
    }
}

@Preview
@Composable
fun PreviewFailPregnancyQuestion(){
    FailPregnancyQuestion()
}