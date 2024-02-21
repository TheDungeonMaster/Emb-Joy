package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pregnancyapp.NormalTextComponent
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.pregnancyapp.ButtonComponentCustomColor
import com.example.pregnancyapp.CustomWhiteTextField
import com.example.pregnancyapp.ReusableText
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pregnancyapp.authentication_logic.AuthViewModel


@Composable
fun MommyQuestionnairePage(navController: NavController, authViewModel: AuthViewModel = viewModel()){

    var nameSurname by remember { mutableStateOf("") }
    var dayOfPregnancy by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }


    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
        ){
            Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
            NormalTextComponent(value = "Mommy", 36)

            Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
            ReusableText(
                text = "Name Surname", textStyle = MaterialTheme
                    .typography.bodyLarge, fontWeight = FontWeight.Normal, Color
                        .Black, Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            CustomWhiteTextField(
                value = nameSurname,
                onValueChange = {
                    nameSurname = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }, Modifier.background(Color.White), Color.White)


            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(
                text = "Current day of pregnancy", textStyle =
                MaterialTheme
                    .typography.bodyLarge, fontWeight = FontWeight.Normal, Color
                        .Black, Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            CustomWhiteTextField(
                value = dayOfPregnancy,
                onValueChange = {
                    dayOfPregnancy = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }, Modifier.background(Color.White), Color.White
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(
                text = "Weight (kg)",
                textStyle =
                MaterialTheme
                    .typography.bodyLarge,
                fontWeight = FontWeight.Normal,
                Color.Black,
                Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            CustomWhiteTextField(
                value = weight,
                onValueChange = {
                    weight = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }, Modifier.background(Color.White), Color.White
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(
                text = "Height (cm)",
                textStyle =
                MaterialTheme
                    .typography.bodyLarge,
                fontWeight = FontWeight.Normal,
                Color.Black,
                Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            CustomWhiteTextField(
                value = height,
                onValueChange = {
                    height = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }, Modifier.background(Color.White), Color.White
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            ButtonComponentCustomColor(
                value = "SUBMIT",
                onClick = {
                    authViewModel.onSubmitButtonClicked(
                        nameSurname,
                        dayOfPregnancy,
                        weight,
                        height,
                        navController
                    )
                },
                color = Color(0xFF75BFCB),
                textColor = Color.Black
            )

        }
    }
}



