package com.example.pregnancyapp.authentication_logic

import androidx.room.Room
import com.example.pregnancyapp.PregApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// AuthService.kt
object AuthService {
    private val userDao = PregApplication.getInstance().userDatabase.userDao()

    suspend fun loginUser(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            userDao.loginUser(email, password) != null
        }
    }

     suspend fun registerUser(user: User): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                userDao.registerUser(user)
                true // Registration successful
            } catch (e: Exception) {
                false // User already exists or registration failed
            }
        }
    }
}
