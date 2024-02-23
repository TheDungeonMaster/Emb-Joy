package com.example.pregnancyapp.authentication_logic.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.pregnancyapp.authentication_logic.Journal
import com.example.pregnancyapp.authentication_logic.User

data class UserAndJournal (
    @Embedded
    val user: User,
    @Relation(parentColumn = "email", entityColumn = "email")
    val journal: Journal
)
