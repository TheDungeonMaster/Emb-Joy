package com.example.pregnancyapp.questionnaire

import com.example.pregnancyapp.authentication_logic.User
import com.example.pregnancyapp.authentication_logic.UserDao

class UserRepository(private val userDao: UserDao, private val questionnaireDao: QuestionnaireDao) {

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun insertQuestionnaireData(questionnaire: QuestionnaireData) {
        questionnaireDao.insertQuestionnaire(questionnaire)
    }

    /*suspend fun getQuestionnaireDataByUserId(userId: Long):
            QuestionnaireData? {
        return questionnaireDao.getQuestionnaireByUserId(userId)
    }*/

}