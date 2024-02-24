package com.example.pregnancyapp.pages

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pregnancyapp.PregApplication
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.Journal
import com.example.pregnancyapp.authentication_logic.User
import com.example.pregnancyapp.authentication_logic.UserDatabase
import com.example.pregnancyapp.calendar.CalendarUiModel
import com.example.pregnancyapp.convertDaysToWeeksAndDays
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.stream.Collectors
import java.util.stream.Stream


class WelcomePageViewModel : ViewModel() {

    private var _user = MutableStateFlow(User("", ""))
    val user = _user.asStateFlow()
    private val userDao = PregApplication.getInstance().userDatabase.userDao()
    private var _journalData = MutableStateFlow(Journal("", "", "", "", "", ""))
    val journalData = _journalData.asStateFlow()

    init {
        getUserData()

    }

    fun getJournalData(date: String) {
        viewModelScope.launch {
            userDao.getJournalWithQuestionnaire(date, AuthService.userEmail).collect {
                _journalData.value =
                    it ?: Journal("N/A", user.value.email, "N/A", "N/A", "N/A", "N/A")
            }
        }
    }

    fun getUserData() {
        viewModelScope.launch {
            Log.i(TAG, "Getting data for user: ${AuthService.userEmail}")
            userDao.getCurrentUserFlow(AuthService.userEmail).collect {
                _user.value = it
            }
        }
    }

    fun toWeekDay(): String {
        return convertDaysToWeeksAndDays(_user.value.dayOfPregnancy?.toInt() ?: 0)
    }


    val today: LocalDate
        get() {
            return LocalDate.now()
        }


    fun getData(startDate: LocalDate = today, lastSelectedDate: LocalDate): CalendarUiModel {
        val firstDayOfWeek = startDate.with(DayOfWeek.MONDAY)
        val endDayOfWeek = firstDayOfWeek.plusDays(7)
        val visibleDates = getDatesBetween(firstDayOfWeek, endDayOfWeek)
        return toUiModel(visibleDates, lastSelectedDate)
    }

    var calendarUiModel = mutableStateOf(getData(today, today))

    private fun getDatesBetween(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
        val numOfDays = ChronoUnit.DAYS.between(startDate, endDate)
        return Stream.iterate(startDate) { date ->
            date.plusDays(/* daysToAdd = */ 1)
        }
            .limit(numOfDays)
            .collect(Collectors.toList())
    }

    private fun toUiModel(
        dateList: List<LocalDate>,
        lastSelectedDate: LocalDate
    ): CalendarUiModel {
        return CalendarUiModel(
            selectedDate = toItemUiModel(lastSelectedDate, true),
            visibleDates = dateList.map {
                toItemUiModel(it, it.isEqual(lastSelectedDate))
            },
        )
    }

    private fun toItemUiModel(date: LocalDate, isSelectedDate: Boolean) = CalendarUiModel.Date(
        isSelected = isSelectedDate,
        isToday = date.isEqual(LocalDate.now()),
        date = date,
    )
}