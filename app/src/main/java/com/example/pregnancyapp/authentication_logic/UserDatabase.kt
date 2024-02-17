package com.example.pregnancyapp.authentication_logic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// UserDatabase.kt
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

object DatabaseModule {
    private var INSTANCE: UserDatabase? = null

    @Synchronized
    fun provideUserDatabase(context: Context): UserDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java, "user_database"
            ).build()
        }
        return INSTANCE!!
    }
}
