package com.example.pregnancyapp

import android.app.Application
import androidx.room.Room
import com.example.pregnancyapp.authentication_logic.UserDatabase

class PregApplication : Application() {
    companion object {
        private lateinit var instance: PregApplication

        @JvmStatic
        fun getInstance(): PregApplication {
            return instance
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        // other initialization code
    }
    val userDatabase: UserDatabase by lazy {
        Room.databaseBuilder(
            this,
            UserDatabase::class.java, "user-database"
        ).build()
    }
}
