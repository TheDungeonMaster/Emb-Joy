package com.example.pregnancyapp.login_register

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen (){
    object SignUpScreen : Screen()
    object TermsAndConditionsScreen: Screen()
}

object LoginPageRouter{
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen
        .SignUpScreen)
    fun navigateTo(destination:Screen){
        currentScreen.value = destination
    }
}