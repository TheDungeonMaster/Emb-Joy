package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.authentication_logic.AuthService

import com.example.pregnancyapp.ButtonComponentConstColor
import com.example.pregnancyapp.EmailTextFieldComponent
import com.example.pregnancyapp.HeadingTextComponent
import com.example.pregnancyapp.NormalTextComponent
import com.example.pregnancyapp.PasswordFieldComponent
import kotlinx.coroutines.launch

@Composable
fun LoginPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(90.dp))
            NormalTextComponent(value = "Hello!", 24)
            HeadingTextComponent(value = "Welcome to EmbryoJourney")
            Spacer(modifier = Modifier.height(25.dp))
            EmailTextFieldComponent(
                labelValue = "Email",
                painterResource(id = R.drawable.email),
                textValue = email,
                onTextValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(15.dp))
            PasswordFieldComponent(
                labelValue = "Password",
                painterResource(id = R.drawable.lock),
                textValue = password,
                onTextValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponentConstColor(value = "LOG IN") {
                if (email.isEmpty() || password.isEmpty()) {
                    // Show an error message or handle empty fields accordingly
                    // For example, you can display a Snackbar or Toast
                    // TODO: Handle empty fields error
                } else {
                    // Call the loginUser function from a coroutine
                    coroutineScope.launch {
                        val loginSuccessful = AuthService.loginUser(email, password)
                        val currUser = AuthService.getCurrentUser()

                        if (currUser != null) {
                            if (currUser.height == null) {
                                navController.navigate("mommyquestionnairepage")
                            } else {
                                navController.navigate("welcome")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            NormalTextComponent(value = "Don't have an account?", 16)
            Spacer(modifier = Modifier.height(30.dp))

            ButtonComponentConstColor(value = "CREATE ACCOUNT") {
                // Navigate to the SignUpPage when the "CREATE ACCOUNT" button is clicked
                navController.navigate("signup")
            }
        }
    }
}





