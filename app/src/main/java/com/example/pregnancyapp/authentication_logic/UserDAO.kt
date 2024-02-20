package com.example.pregnancyapp.authentication_logic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

// UserDao.kt
@Dao
interface UserDao {
    @Upsert
    suspend fun insert(user: User)
    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun loginUser(email: String, password: String): User?

    @Update
    suspend fun updateUser(user: User)

    @Upsert
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getCurrentUser(): User?

    @Update
    suspend fun updateUserWithQuestionnaireData(user: User)

}
