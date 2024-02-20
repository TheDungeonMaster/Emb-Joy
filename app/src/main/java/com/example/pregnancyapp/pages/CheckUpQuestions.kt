package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pregnancyapp.BooleanCheckUpQuestions
import com.example.pregnancyapp.R
import com.example.pregnancyapp.TextFieldCheckUpQuestion

@Composable
fun CheckUpQuestions(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ){
            TextFieldCheckUpQuestion("How much do you weigh today?", R
                .drawable.weight_scale_logo)
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldCheckUpQuestion("Please enter today's blood sugar " +
                    "readings", R.drawable.blood_sugar_logo)
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldCheckUpQuestion("Please enter today's blood pressure " +
                    "readings.", R.drawable.blood_pressure_logo)
            Spacer(modifier = Modifier.height(20.dp))
            BooleanCheckUpQuestions(
                questionText = "Did you experience any swelling in your legs today?",
                iconInt = R.drawable.leg_swellings_logo
            )
            Spacer(modifier = Modifier.height(20.dp))

            BooleanCheckUpQuestions(
                questionText = "Did you experience any swelling in your legs today?",
                iconInt = R.drawable.menstruation_logo
            )
        }
    }
}

@Preview
@Composable
fun PreviewCheckUpQuestions(){
    CheckUpQuestions()
}