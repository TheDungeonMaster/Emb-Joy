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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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
        viewModelScope.launch {
            userDao.insertJournal(
                journal = Journal(
                    "21.02.24",
                    "jane.jj@mail.com",
                    "Jane JJ",
                    "131",
                    "56",
                    "174",
                    "120/80",
                    "5.4",
                    false,
                    false,
                    "Great, no changes",
                    "No comments today"
                )
            )
            userDao.insertJournal(
                journal = Journal(
                    "22.02.24",
                    "jane.jj@mail.com",
                    "Jane JJ",
                    "131",
                    "58",
                    "174",
                    "120/80",
                    "5.4",
                    true,
                    true,
                    "Okay",
                    "No comments today"
                )
            )
            userDao.insertJournal(
                journal = Journal(
                    "23.02.24",
                    "jane.jj@mail.com",
                    "Jane JJ",
                    "131",
                    "59",
                    "174",
                    "120/80",
                    "5.2",
                    true,
                    false,
                    "So so",
                    "Registered for an appointment with my doctor"
                )
            )
            userDao.insertJournal(
                journal = Journal(
                    "24.02.24",
                    "jane.jj@mail.com",
                    "Jane JJ",
                    "131",
                    "60",
                    "174",
                    "120/80",
                    "6",
                    false,
                    true,
                    "Good",
                    "No comments today"
                )
            )
        }

        getUserData()
        getJournalData(today.format(DateTimeFormatter.ofPattern("dd.MM.yy")))
        Log.d(TAG, "")
    }

    fun getJournalData(date: String) {
        viewModelScope.launch {
            userDao.getJournalWithQuestionnaire(date, AuthService.userEmail).collect { journalData ->
                _journalData.emit(journalData ?: Journal("",""))
            }
        }
    }

    fun updateJournalData(date: String) {
        val email = AuthService.userEmail // Assuming you have access to the current user's email

        viewModelScope.launch {

            userDao.getJournalWithQuestionnaire(date, email).collect { journal ->
                // Check if the journal is not null then emit the updated journal data
                // This will trigger UI recomposition if there are any collectors
                journal?.let {
                    _journalData.emit(it)
                }
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