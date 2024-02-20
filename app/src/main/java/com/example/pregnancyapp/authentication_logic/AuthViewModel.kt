package com.example.pregnancyapp.authentication_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.questionnaire.QuestionnaireData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel : ViewModel() {
    private val userDao = PregApplication.getInstance().userDatabase.userDao()

    private var currentUser: User? = null

    fun onSubmitButtonClicked(
        nameSurname: String,
        dayOfPregnancy: String,
        weight: String,
        height: String,
        navController: NavController
    ) {
        viewModelScope.launch {
            // Retrieve the current user
            val currentUser = getCurrentUser()

            // Check if the user is logged in
            if (currentUser != null) {
                // Create a QuestionnaireData object
                val questionnaireData = QuestionnaireData(
                    nameSurname = nameSurname,
                    dayOfPregnancy = dayOfPregnancy,
                    weight = weight,
                    height = height
                    // Add other fields as needed
                )

                // Update the user with the attached QuestionnaireData
                val updateSuccessful = updateUserWithQuestionnaireData(
                    currentUser = currentUser,
                    questionnaireData = questionnaireData
                )

                if (updateSuccessful) {
                    // Navigate to the next screen (if needed)
                    navController.navigate("questionpregnancynumber")
                } else {
                    // Handle update failure
                    // You might want to show an error message to the user
                    // or handle the situation according to your app's logic
                    println("Failed to update user with questionnaire data.")
                }
            } else {
                // Handle the case when the user is not logged in
                // You might want to show an error message or take appropriate action
                println("User not logged in.")
            }
        }
    }
    suspend fun getCurrentUser(): User? {
        return withContext(Dispatchers.IO) {
            // Retrieve the current user from your data source (e.g., database)
            // You might need to adjust this part based on your actual data source
            userDao.getCurrentUser()
        }
    }

    suspend fun updateUserWithQuestionnaireData(
        currentUser: User,
        questionnaireData: QuestionnaireData
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                // Update the user with questionnaire data within a coroutine
                currentUser.questionnaireData = questionnaireData  // Set the questionnaire data
                userDao.updateUserWithQuestionnaireData(currentUser)
                true // Update successful
            } catch (e: Exception) {
                println("Error during updating user with questionnaire data: ${e.message}")
                false // Update failed
            }
        }
    }
    suspend fun registerUserAndFetchQuestionnaire(
        email: String,
        password: String
    ): Boolean {
        // Register the user
        val newUser = User(email = email, password = password)
        val registrationSuccessful = AuthService.registerUser(newUser)

        if (registrationSuccessful) {
            // Fetch questionnaire data for the user
            val loggedInUser =
                userDao.loginUser(email, password) // Retrieve user
            val questionnaireData = loadQuestionnaireDataForUser(loggedInUser!!)

            // Update user with questionnaireData
            AuthService.updateUserWithQuestionnaireData(
                loggedInUser,
                questionnaireData
            )
        }

        return registrationSuccessful
    }


    private suspend fun loadQuestionnaireDataForUser(user: User): QuestionnaireData {
        // Implement logic to load questionnaire data for the user
        // You may fetch this data from the database or any other source
        return QuestionnaireData(
            nameSurname = user.nameSurname,
            dayOfPregnancy = user.dayOfPregnancy,
            weight = user.weight,
            height = user.height
            // Add other questionnaire fields as needed
        )
    }

}
