package com.example.pregnancyapp.authentication_logic

import androidx.room.Entity
import androidx.room.PrimaryKey

// User.kt
@Entity(tableName = "users")
data class User(
    @PrimaryKey val email: String,
    val password: String
)
