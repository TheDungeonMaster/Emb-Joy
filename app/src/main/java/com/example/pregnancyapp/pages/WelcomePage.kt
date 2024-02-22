package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.pregnancyapp.R
import com.example.pregnancyapp.CircleShapeComponent
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.authentication_logic.AuthViewModel


@Composable
fun WelcomePage(authViewModel: AuthViewModel, viewModel: WelcomePageViewModel){

    val user = viewModel.user.collectAsState()
    viewModel.getUserData()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .padding(30.dp)
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
            ReusableIcon(iconResourceId = R.drawable.bell, iconSize =
            35, scaleSize = 1f, 0)

        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top
        ){
            CircleShapeComponent(authViewModel, user.value)

        }
    }
}

