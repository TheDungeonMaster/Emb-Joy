package com.example.pregnancyapp.questionnaire

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface QuestionnaireDao {
    @Insert
    suspend fun insertQuestionnaire(questionnaire: QuestionnaireData)

    @Update
    suspend fun updateQuestionnaire(questionnaire: QuestionnaireData)

    /*@Query("SELECT * FROM QuestionnaireData WHERE userId = :userId")
    suspend fun getQuestionnaireByUserId(userId: Long): QuestionnaireData?*/
}