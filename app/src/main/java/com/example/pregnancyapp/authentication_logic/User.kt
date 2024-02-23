package com.example.pregnancyapp.authentication_logic

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.pregnancyapp.questionnaire.QuestionnaireData

// User.kt
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = false)
    val email: String,
    val password: String,
    var nameSurname: String? = null,
    var dayOfPregnancy: String? = null,
    var weight: String? = null,
    var height: String? = null,
    var numOfPregnancies: String? = null,
    var numOfFailedPregnancies: String? = null,
    var hasDiabetes: Boolean = false,
    var hasHighBloodPressure: Boolean = false,
    var hasAsthma: Boolean = false,
    var hasFertilityIssues: Boolean = false,
    var hasMentalHealthConditions: Boolean = false,
    var hasObesity: Boolean = false,
    var hasOtherCondition: Boolean = false,

    @Embedded(prefix = "questionnaire_")
    var questionnaireData: QuestionnaireData? = null,

)