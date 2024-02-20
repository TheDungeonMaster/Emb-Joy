package com.example.pregnancyapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pregnancyapp.pages.FailPregnancyQuestion
import com.example.pregnancyapp.pages.FirstPregnancyQuestion
import com.example.pregnancyapp.pages.LoginPage
import com.example.pregnancyapp.pages.MommyQuestionnairePage
import com.example.pregnancyapp.pages.NumOfFailedPregnancies
import com.example.pregnancyapp.pages.NumOfPregnancies
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
        addMommyQuestionnairePage(navController)
        addNumOfPregnanciesQuestion(navController)
        addNumOfPregnanciesAnswer(navController)
        addFailedPregnanciesQuestion(navController)
        addFailedPregnanciesAnswer(navController)
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

fun NavGraphBuilder.addMommyQuestionnairePage(navController: NavController) {
    composable("mommyquestionnairepage") {
        MommyQuestionnairePage(navController)
    }
}

fun NavGraphBuilder.addNumOfPregnanciesQuestion(navController: NavController) {
    composable("questionpregnancynumber") {
        FirstPregnancyQuestion(navController)
    }
}

fun NavGraphBuilder.addNumOfPregnanciesAnswer(navController: NavController) {
    composable("pregnancynumber") {
        NumOfPregnancies(navController)
    }
}

fun NavGraphBuilder.addFailedPregnanciesQuestion(navController: NavController) {
    composable("questionfailedpregnancies") {
        FailPregnancyQuestion(navController)
    }
}

fun NavGraphBuilder.addFailedPregnanciesAnswer(navController: NavController) {
    composable("failnumber") {
        NumOfFailedPregnancies(navController)
    }
}
