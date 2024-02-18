package com.example.pregnancyapp.questionnaire

data class QuestionnaireData(
    val userId: Long,
    val name: String,
    val surname: String,
    val daysOfPregnancy: Int,
    val weight: Float,
    val height: Float,
    val pregnancies: Int,
    val failedPregnancies: Int,
    val medicalConditions: List<String>
)