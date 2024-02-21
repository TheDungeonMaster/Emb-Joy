package com.example.pregnancyapp.authentication_logic

import android.content.ContentValues.TAG
import android.util.Log
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
        weight: String?,
        height: String?,
        navController: NavController
    ) {
        viewModelScope.launch {
            // Retrieve the current user
            val currentUser = AuthService.getCurrentUser()
            if (currentUser != null) {
                AuthService.loginUser(currentUser.email, currentUser.password)
                Log.i(currentUser.email, "Email of the current user")
            }

            // Check if the user is logged in
            if (currentUser != null) {
                Log.i(TAG, "Not null")

                val questionnaireData = QuestionnaireData(
                    nameSurname = nameSurname,
                    dayOfPregnancy = dayOfPregnancy,
                    weight = weight,
                    height = height
                )

                val updateSuccessful = AuthService.updateUserWithQuestionnaireData(
                    currentUser,
                    questionnaireData
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
    suspend fun getCurrentUser() {
        AuthService.getCurrentUser()
    }

    suspend fun updateUserWithQuestionnaireData(
        currentUser: User,
        questionnaireData: QuestionnaireData
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                // Set the questionnaireData field
                currentUser.questionnaireData = questionnaireData
                // Update the user with questionnaire data within a coroutine
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
            // Check if the user is newly registered
            val isNewlyRegistered = AuthService.isUserNewlyRegistered(email)

            if (isNewlyRegistered) {
                // Fetch questionnaire data for the user
                val loggedInUser = userDao.loginUser(email, password) // Retrieve user
                val questionnaireData = loadQuestionnaireDataForUser(loggedInUser!!)

                // Update user with questionnaireData
                AuthService.updateUserWithQuestionnaireData(
                    loggedInUser,
                    questionnaireData
                )
            }
        }

        return registrationSuccessful
    }


    // PREV. PREGNANCIES NUMBER /////////

    fun handleNumOfPregnanciesQuestion(pregNum: String) {
        viewModelScope.launch {
            handleNumOfPregnanciesSelection(pregNum)
        }
    }


    suspend fun handleNumOfPregnanciesSelection(pregnancyNumber: String) {
        val user = AuthService.getCurrentUser()

        if (user != null) {
           // user.numOfPregnancies = pregnancyNumber
            userDao.updatePregnancyNumberDAO(user.email, pregnancyNumber)
        }
    }


    // FAILED PREGNANCIES/////////
    fun handleNumOfFailedPregnanciesQuestion(failNum:
                                              String) {
        viewModelScope.launch{
            handleNumOfFailedPregnanciesSelection(failNum)
        }
    }

    suspend fun handleNumOfFailedPregnanciesSelection(failedNumber:
    String) {
        val user = AuthService.getCurrentUser()

        if (user != null) {
            //user.numOfFailedPregnancies = failedNumber
            userDao.updateFailedPregnancyNumberDAO(user.email, failedNumber)
        }
    }

    private suspend fun loadQuestionnaireDataForUser(user: User): QuestionnaireData {
        return QuestionnaireData(
            nameSurname = user.nameSurname,
            dayOfPregnancy = user.dayOfPregnancy,
            weight = user.weight,
            height = user.height
            // Add other questionnaire fields as needed
        )
    }



    // MEDICAL CONDITIONS


    fun handleSelectedMedicalConditions(medicalCondition: String) {
        viewModelScope.launch {
            val currentUser = AuthService.getCurrentUser()
            if (currentUser != null) {
                // Update the user with the selected condition
                currentUser.apply {
                    when (medicalCondition) {
                        "diabetes" -> hasDiabetes = true
                        "highBloodPressure" -> hasHighBloodPressure = true
                        "asthma" -> hasAsthma = true
                        "fertilityIssues" -> hasFertilityIssues = true
                        "mentalHealthConditions" -> hasMentalHealthConditions = true
                        "obesity" -> hasObesity = true
                        "otherCondition" -> hasOtherCondition = true
                        // Handle other conditions if needed
                    }
                    userDao.updateMedicalCondition(
                        email,
                        hasDiabetes,
                        hasHighBloodPressure,
                        hasAsthma,
                        hasFertilityIssues,
                        hasMentalHealthConditions,
                        hasObesity,
                        hasOtherCondition
                    )
                }
            }
        }
    }


}
