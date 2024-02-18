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
import com.example.pregnancyapp.authentication_logic.User

import com.example.pregnancyapp.login_register.components.ButtonComponentConstColor
import com.example.pregnancyapp.login_register.components.CheckboxComponent
import com.example.pregnancyapp.login_register.components.EmailTextFieldComponent
import com.example.pregnancyapp.login_register.components.HeadingTextComponent
import com.example.pregnancyapp.login_register.components.MyTextFieldComponent
import com.example.pregnancyapp.login_register.components.NormalTextComponent
import com.example.pregnancyapp.login_register.components.PasswordFieldComponent
import kotlinx.coroutines.launch

@Composable
fun SignUpPage(navController: NavController){

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var termsChecked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
        ){
            Spacer(modifier = Modifier.height(30.dp))
            NormalTextComponent(value = "Hello!", 24)
            HeadingTextComponent(value = "Create an account")
            Spacer(modifier = Modifier.height(25.dp))
            MyTextFieldComponent(
                labelValue = "First name",
                painterResource(id = R.drawable.profile),
                textValue = firstName,
                onTextValueChange = { firstName = it }
            )
            Spacer(modifier = Modifier.height(10.dp))

            MyTextFieldComponent(
                labelValue = "Last name",
                painterResource(id = R.drawable.profile),
                textValue = lastName,
                onTextValueChange = { lastName = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            EmailTextFieldComponent(
                labelValue = "Email",
                painterResource(id = R.drawable.email),
                textValue = email,
                onTextValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            PasswordFieldComponent(
                labelValue = "Password",
                painterResource(id = R.drawable.lock),
                textValue = password,
                onTextValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            CheckboxComponent(value = "Terms and Conditions",onTextSelected = {
            },
                onCheckedChange = {
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponentConstColor(
                value = "REGISTER",
                onClick = {
                    coroutineScope.launch {
                        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                            // Handle empty fields error
                            println("Error: Empty fields")
                        } else {
                            val newUser = User(email = email, password =
                                password)

                            try {
                                if (AuthService.registerUser(newUser)) {
                                    navController.navigate("login")
                                } else {
                                    // Handle registration failed error
                                    println("Error: Registration failed")
                                }
                            } catch (e: Exception) {
                                // Log the exception
                                println("Error: ${e.message}")
                            }
                        }
                    }
                }
            )
        }
    }
}


