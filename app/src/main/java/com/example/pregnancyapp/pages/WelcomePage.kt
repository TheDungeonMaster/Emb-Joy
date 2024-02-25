package com.example.pregnancyapp.pages

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.calendar.Calendar
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.pregnancyapp.CustomBottomNavigationBar
import com.example.pregnancyapp.authentication_logic.AuthService
import java.time.LocalDate
import java.time.format.DateTimeFormatter



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(
    navController: NavController,
    daysLeft: Int,
    weekDayOfPregnancy: String,
    viewModel: WelcomePageViewModel,
    onJournalAddButtonClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getUserData()
        viewModel.getJournalData(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy")))
        Log.d(TAG, "")
    }

    val journalData by viewModel.journalData.collectAsState()
    val scrollState = rememberScrollState()
    val fullName = AuthService.getCurrentUser()?.nameSurname
    val firstName = fullName?.substringBefore(" ") ?: "Default"
    viewModel.getUserData()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onJournalAddButtonClick() },
                containerColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFF63B8C3))
            }
        },
        bottomBar = {
            CustomBottomNavigationBar(navController = navController, R
            .drawable.union_active, R.drawable.bot_icon, R
            .drawable.profile_nonactive, Modifier, Color.White)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEBF5F6))
                .padding(it),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier.background(Color(0xFFEBF5F6))
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                ) {


                    ReusableText(
                        text = "Welcome, $firstName",
                        textStyle = MaterialTheme
                            .typography.headlineMedium,
                        fontWeight = Bold,
                        Color.Black,
                        Modifier.padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.weight(2f))
                    ReusableIcon(
                        iconResourceId = R.drawable.bell, iconSize =
                        35, scaleSize = 1f, 0
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier

                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFEBF5F6).copy(alpha = 0.5f) ,
                                    Color(0xFFEBF5F6).copy(alpha = 0.3f)
                                )
                            )
                        )
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))

                ) {
                    Calendar(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp))
                }

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(scrollState)
                ) {
                    CircleShapeComponent(daysLeft, weekDayOfPregnancy)
                    JournalScreen(
                        weight = journalData.weight.toString(),
                        bloodSugar = journalData.bloodSugar.toString(),
                        bloodPressure = journalData.bloodPressure.toString(),
                        legSwellings = journalData.swellings,
                        bleeding = journalData.bleeding,
                        mood = journalData.mood.toString(),
                        comments = journalData.comments.toString()
                    )

                }

            }

        }
    }
}


@Composable
fun CircleShapeComponent(
    daysLeft: Int,
    weekDayOfPregnancy: String
) {
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(30.dp)
                .background(
                    Color(android.graphics.Color.parseColor("#64BCB9")) ,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center // Center the content inside the Box
        ) {
            ReusableIcon(
                iconResourceId = R.drawable.baby_embryo, iconSize = 130,
                scaleSize = 2.5f, 20
            )

            Column(

            ) {
                Spacer(modifier = Modifier.height(230.dp))
                ReusableText(
                    text = weekDayOfPregnancy, MaterialTheme.typography
                        .headlineMedium, FontWeight.ExtraBold, Color.White, Modifier.padding
                        (start = 10.dp)
                )
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    ReusableText(
                        text = "$daysLeft days left", MaterialTheme
                            .typography
                            .headlineSmall, FontWeight.Normal,
                        Color.White, Modifier.padding(
                            start = 10
                                .dp,
                            bottom = 15.dp
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomePagePreview() {
//    WelcomePage(18 , "Week 8 day 2", viewModel(), {})
}


@Preview(showSystemUi = true)
@Composable
fun Welcome() {
    CircleShapeComponent(daysLeft = 10, weekDayOfPregnancy = "10 Week 2 day")
}
