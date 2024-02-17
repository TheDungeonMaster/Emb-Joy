package com.example.pregnancyapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pregnancyapp.pages.LoginPage
import com.example.pregnancyapp.pages.SignUpPage
import com.example.pregnancyapp.pages.WelcomePage


// MainComposable.kt
@Composable
fun MainComposable() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        addWelcomePage(navController)
        addLoginPage(navController)
        addSignUpPage(navController)
    }
}

fun NavGraphBuilder.addWelcomePage(navController: NavController) {
    composable("welcome") {
        WelcomePage()
    }
}

fun NavGraphBuilder.addLoginPage(navController: NavController) {
    composable("login") {
        LoginPage(navController)
    }
}

fun NavGraphBuilder.addSignUpPage(navController: NavController) {
    composable("signup") {
        SignUpPage(navController)
    }
}
