package com.example.pregnancyapp.pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PersonalDataViewModel : ViewModel() {


    private var _userData = MutableStateFlow(UserData())
    var userData = _userData.asStateFlow()
    private val userDao = PregApplication.getInstance().userDatabase.userDao()



    init {
        updateUserData()
    }
    fun updateUserData() {

        viewModelScope.launch {
            userDao.getCurrentUserFlow(AuthService.userEmail).collect {
                _userData.value = _userData.value.copy(
                    name = it.nameSurname ?: "",
                    dayofPregnancy = it.dayOfPregnancy ?: "",
                    height = it.height ?: "",
                    weight = it.weight ?: "",
                    failedPregnancies = it.numOfFailedPregnancies ?: ""
                )

            }
        }

    }

}

data class UserData(
        var name: String = "",
        var dayofPregnancy: String = "",
        var failedPregnancies: String = "",
        var height: String = "",
        var weight: String = ""
        )