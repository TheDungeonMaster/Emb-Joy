package com.example.pregnancyapp.authentication_logic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// UserDatabase.kt
@Database(entities = arrayOf(User::class, Journal::class), version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Perform necessary database migration here.
                // In this example, we are not making any changes, just ensuring the table exists.
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS users(" +
                            "email TEXT PRIMARY KEY," +
                            "password TEXT," +
                            "nameSurname TEXT," +
                            "dayOfPregnancy TEXT," +
                            "weight TEXT," +
                            "height TEXT," +
                            "questionnaire_newField TEXT)"
                )
            }
        }

        fun provideUserDatabase(context: Context): UserDatabase {
            println("Initializing user database...")
            return Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java, "user_database"
            ).fallbackToDestructiveMigration()
                .addMigrations(migration_1_2)
                .build()
        }
    }
}

