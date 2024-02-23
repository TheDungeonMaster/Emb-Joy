package com.example.pregnancyapp.pages

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.User
import com.example.pregnancyapp.convertDaysToWeeksAndDays
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch


class WelcomePageViewModel : ViewModel() {

    private var _user = MutableStateFlow(User("" , ""))
    val user = _user.asStateFlow()
    private val userDao = PregApplication.getInstance().userDatabase.userDao()



    fun getUserData() {
        viewModelScope.launch{
            Log.i(TAG , "Getting data for user: ${AuthService.userEmail}")
            userDao.getCurrentUserFlow(AuthService.userEmail).collect{
                _user.value = it
            }
        }
    }

    fun toWeekDay(): String {
        return convertDaysToWeeksAndDays(_user.value.dayOfPregnancy?.toInt() ?: 0)
    }
}