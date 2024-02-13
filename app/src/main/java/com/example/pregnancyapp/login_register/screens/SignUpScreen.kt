package com.example.pregnancyapp.login_register.screens

import android.graphics.Color.RED
import android.graphics.Color.WHITE
import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.login_register.LoginPage
import com.example.pregnancyapp.login_register.LoginPageRouter
import com.example.pregnancyapp.login_register.Screen
import com.example.pregnancyapp.login_register.components.CheckboxComponent
import com.example.pregnancyapp.login_register.components.EmailTextFieldComponent
import com.example.pregnancyapp.login_register.components.HeadingTextComponent
import com.example.pregnancyapp.login_register.components.MyTextFieldComponent
import com.example.pregnancyapp.login_register.components.NormalTextComponent
import com.example.pregnancyapp.login_register.components.PasswordFieldComponent

@Composable
fun SignUpScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
        ){
            Spacer(modifier = Modifier.height(30.dp))
            NormalTextComponent(value = "Hello!")
            HeadingTextComponent(value = "Create an account")
            Spacer(modifier = Modifier.height(25.dp))
            MyTextFieldComponent(labelValue = "First name", painterResource(id = R.drawable.profile))
            Spacer(modifier = Modifier.height(10.dp))
            MyTextFieldComponent(labelValue = "Last name", painterResource(id = R.drawable.profile))
            Spacer(modifier = Modifier.height(10.dp))
            EmailTextFieldComponent(labelValue = "Email", painterResource(id
            = R
                .drawable.email))
            Spacer(modifier = Modifier.height(10.dp))
            PasswordFieldComponent(labelValue = "Password", painterResource(id
            = R.drawable.lock))
            Spacer(modifier = Modifier.height(10.dp))

            CheckboxComponent(
                value = "Terms and Conditions",
                onTextSelected = {
                    LoginPageRouter.navigateTo(Screen.TermsAndConditionsScreen)
                },
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}

