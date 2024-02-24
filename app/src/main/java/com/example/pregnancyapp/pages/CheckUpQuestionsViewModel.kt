package com.example.pregnancyapp.pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.Journal
import com.example.pregnancyapp.calendar.CalendarUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CheckUpQuestionsViewModel : ViewModel() {

    private val _checkUpQuestionsState = MutableStateFlow(CheckUpQuestionsState())
    val checkUpQuestionsState = _checkUpQuestionsState.asStateFlow()
    val formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"))


    private val userDao = PregApplication.getInstance().userDatabase.userDao()
    private var _journalData = MutableStateFlow(Journal("", "", "", "", "", ""))
    val journalData = _journalData.asStateFlow()

    fun onSubmitButtonClick(onComplete: () -> Unit) {
        viewModelScope.launch{
            userDao.insertJournal(Journal(
                date = formattedDate.toString(),
                email = AuthService.userEmail,
                nameSurname = "",
                dayOfPregnancy = "",
                height = "",
                bloodPressure = checkUpQuestionsState.value.bloodPressure,
                bloodSugar = checkUpQuestionsState.value.bloodSugar,
                weight = checkUpQuestionsState.value.weightField,
                swellings = checkUpQuestionsState.value.swellings,
                bleeding = checkUpQuestionsState.value.bleeding
            ))
        }
        updateState(_checkUpQuestionsState.value.copy(
            weightField = "",
            bloodSugar = "",
            bloodPressure = "",
            swellings = false,
            bleeding = false,
        ))
        onComplete()
    }

    fun onWeightFieldChange(value: String) {
        updateState(_checkUpQuestionsState.value.copy(weightField = value))
    }

    fun onBloodSugarChange(value: String) {
        updateState(_checkUpQuestionsState.value.copy(bloodSugar = value))
    }

    fun onBloodPressureChange(value: String) {
        updateState(_checkUpQuestionsState.value.copy(bloodPressure = value))
    }

    fun onSwellingsTrueButtonClick() {
        updateState(_checkUpQuestionsState.value.copy(swellings = true))
    }

    fun onSwellingsFalseButtonClick() {
        updateState(_checkUpQuestionsState.value.copy(swellings = false))
    }

    fun onBleedingTrueButtonClick() {
        updateState(_checkUpQuestionsState.value.copy(bleeding = true))
    }

    fun onBleedingFalseButtonClick() {
        updateState(_checkUpQuestionsState.value.copy(bleeding = false))
    }

    private fun updateState(newState: CheckUpQuestionsState) {
        _checkUpQuestionsState.value = newState
    }
}

data class CheckUpQuestionsState(
    var weightField: String = "",
    var bloodSugar: String = "",
    var bloodPressure: String = "",
    var swellings: Boolean = false,
    var bleeding: Boolean = false
        )