package com.example.pregnancyapp.authentication_logic

import androidx.room.Room
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.questionnaire.QuestionnaireData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// AuthService.kt
object AuthService {
    private val userDao = PregApplication.getInstance().userDatabase.userDao()

    private var currentUser: User? = null

    // Function to retrieve the current user
    fun getCurrentUser(): User? {
        return if (isUserLoggedIn()) {
            currentUser
        } else {
            null
        }
    }

    private fun isUserLoggedIn(): Boolean {
        // Implement your logic to check if the user is logged in
        // For example, check if currentUser is not null or if there's a valid authentication token
        return currentUser != null
    }
    suspend fun loginUser(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val user = userDao.loginUser(email, password)
            if (user != null) {
                println("Login successful for user: $user")
                true
            } else {
                println("Login failed. User not found.")
                false
            }
        }
    }

    suspend fun updateUserWithQuestionnaireData(user: User, questionnaireData: QuestionnaireData): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val updatedUser = user.copy(
                    nameSurname = questionnaireData.nameSurname,
                    dayOfPregnancy = questionnaireData.dayOfPregnancy,
                    weight = questionnaireData.weight,
                    height = questionnaireData.height
                )
                userDao.updateUser(updatedUser)
                true // Update successful
            } catch (e: Exception) {
                println("Error during updating user with questionnaire data: ${e.message}")
                false // Update failed
            }
        }
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

    suspend fun registerUser(user: User): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                userDao.registerUser(user)
                println("Registration successful for user: $user")
                true // Registration successful
            } catch (e: Exception) {
                println("Error during registration: ${e.message}")
                e.printStackTrace() // Print stack trace for more details
                false // User already exists or registration failed
            }
        }
    }
}
