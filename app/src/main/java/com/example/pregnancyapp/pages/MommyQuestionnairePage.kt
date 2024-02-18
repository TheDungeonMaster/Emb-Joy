package com.example.pregnancyapp.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pregnancyapp.login_register.components.NormalTextComponent
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pregnancyapp.login_register.components.MyTextFieldComponent
import com.example.pregnancyapp.login_register.components.ReusableText
import com.example.pregnancyapp.login_register.components.SimpleWhiteTextField


@Composable
fun MommyQuestionnairePage(){

    var enteredText by remember { mutableStateOf("") }

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
            ReusableText(text = "Name Surname", textStyle = MaterialTheme
                .typography.bodyLarge, fontWeight = FontWeight.Normal, Color
                    .Black)
            SimpleWhiteTextField(
                value = enteredText,
                onValueChange = {
                    enteredText = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                })


            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(text = "Current day of pregnancy", textStyle =
            MaterialTheme
                .typography.bodyLarge, fontWeight = FontWeight.Normal, Color
                    .Black)
            SimpleWhiteTextField(
                value = enteredText,
                onValueChange = {
                    enteredText = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(text = "Weight (kg)", textStyle =
            MaterialTheme
                .typography.bodyLarge, fontWeight = FontWeight.Normal, Color.Black)
            SimpleWhiteTextField(
                value = enteredText,
                onValueChange = {
                    enteredText = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
            ReusableText(text = "Height (cm)", textStyle =
            MaterialTheme
                .typography.bodyLarge, fontWeight = FontWeight.Normal, Color.Black)
            SimpleWhiteTextField(
                value = enteredText,
                onValueChange = {
                    enteredText = it // Update the state variable with the new text
                    // Perform any additional actions or validations here if needed
                }
            )

        }
    }
}
