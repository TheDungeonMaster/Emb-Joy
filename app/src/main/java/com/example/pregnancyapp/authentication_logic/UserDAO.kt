package com.example.pregnancyapp.authentication_logic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.example.pregnancyapp.questionnaire.QuestionnaireData
import kotlinx.coroutines.flow.Flow

// UserDao.kt
@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun loginUser(email: String, password: String): User?

    @Update
    suspend fun updateUser(user: User)

    @Insert
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getCurrentUser(email: String): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    fun getCurrentUserFlow(email: String): Flow<User>



    // Use @Update to update the embedded field directly

    // Or, if the questionnaireData is a separate entity, you might need to fetch the user first and then update
    @Update
    suspend fun updateUserWithQuestionnaireData(user: User)

    @Query("UPDATE users SET numOfPregnancies = :numOfPregnancies WHERE email = :email")
    suspend fun updatePregnancyNumberDAO(email: String, numOfPregnancies:
    String)

    @Query("UPDATE users SET numOfFailedPregnancies = :numOfFailedPregnancies WHERE email = :email")
    suspend fun updateFailedPregnancyNumberDAO(email: String,
                                             numOfFailedPregnancies: String)

    @Update
    suspend fun previousPregnanciesQuestionData(user: User)

    @Update
    suspend fun updateUserSelectedConditions(user: User)

    @Query("UPDATE users SET hasDiabetes = :hasDiabetes, " +
            "hasHighBloodPressure = :hasHighBloodPressure, " +
            "hasAsthma = :hasAsthma, " +
            "hasFertilityIssues = :hasFertilityIssues, " +
            "hasMentalHealthConditions = :hasMentalHealthConditions, " +
            "hasObesity = :hasObesity, " +
            "hasOtherCondition = :hasOtherCondition " +
            "WHERE email = :email")
    suspend fun updateMedicalCondition(
        email: String,
        hasDiabetes: Boolean,
        hasHighBloodPressure: Boolean,
        hasAsthma: Boolean,
        hasFertilityIssues: Boolean,
        hasMentalHealthConditions: Boolean,
        hasObesity: Boolean,
        hasOtherCondition: Boolean
    )
}

