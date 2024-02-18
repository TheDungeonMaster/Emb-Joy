package com.example.pregnancyapp.questionnaire

import androidx.lifecycle.ViewModel

class QuestionViewModel(private val userRepository: UserRepository) : ViewModel() {
    // ... other ViewModel methods

  /*  suspend fun getQuestionnaireData(userId: Long): QuestionnaireData? {
        return userRepository.getQuestionnaireDataByUserId(userId)
    }*/

    suspend fun saveQuestionnaireData(questionnaire: QuestionnaireData) {
        userRepository.insertQuestionnaireData(questionnaire)
    }
}
