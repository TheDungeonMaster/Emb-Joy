package com.example.pregnancyapp.pages

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.AuthViewModel
import com.example.pregnancyapp.authentication_logic.User
import com.example.pregnancyapp.calendar.Calendar
import androidx.compose.material3.FloatingActionButtonElevation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(
    daysLeft: Int,
    weekDayOfPregnancy: String,
    viewModel: WelcomePageViewModel,
    onJournalAddButtonClick: () -> Unit
) {

    val journalData by viewModel.journalData.collectAsState()
    val scrollState = rememberScrollState()
    viewModel.getUserData()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onJournalAddButtonClick() },
                containerColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFF63B8C3))
            }
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
                        text = "Welcome!",
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
                                    Color(0xFFEBF5F6).copy(alpha = 0.5f),
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
                        bleeding = journalData.bleeding
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
                    Color(android.graphics.Color.parseColor("#64BCB9")),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center // Center the content inside the Box
        ) {
            ReusableIcon(
                iconResourceId = R.drawable.baby_embryo, iconSize = 130,
                scaleSize = 2.5f, 20
            )


//        if(AuthService.getCurrentUser()?.dayOfPregnancy?.toInt()==null){
//            Log.i(ContentValues.TAG , "it is null")
//        } else {
//            Log.i(ContentValues.TAG , "it is NOT null")
//        }
//

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
