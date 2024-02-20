package com.example.pregnancyapp.authentication_logic

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pregnancyapp.questionnaire.QuestionnaireData

// User.kt
@Entity(tableName = "users")
data class User(
    @PrimaryKey val email: String,
    val password: String,
    var nameSurname: String? = null,
    var dayOfPregnancy: String? = null,
    var weight: String? = null,
    var height: String? = null,
    @Embedded(prefix = "questionnaire_")
    var questionnaireData: QuestionnaireData? = null
)

