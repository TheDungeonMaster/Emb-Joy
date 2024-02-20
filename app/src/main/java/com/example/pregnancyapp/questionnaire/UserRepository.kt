package com.example.pregnancyapp.questionnaire

import com.example.pregnancyapp.authentication_logic.User
import com.example.pregnancyapp.authentication_logic.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        println("Inserting user: $user")
        userDao.insert(user)
    }

}