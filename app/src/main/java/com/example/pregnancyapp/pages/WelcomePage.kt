package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pregnancyapp.R
import com.example.pregnancyapp.login_register.components.CircleShapeComponent
import com.example.pregnancyapp.login_register.components.ReusableIcon
import com.example.pregnancyapp.login_register.components.ReusableText


@Composable
fun WelcomePage(){
    Column (
        modifier = Modifier
            .fillMaxSize().
            background(Color.White)
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .padding(30.dp)


        ) {
            ReusableText(text = "Welcome!", textStyle = MaterialTheme
                .typography.headlineMedium, fontWeight = Bold)
            Spacer(modifier = Modifier.weight(2f))
            ReusableIcon(iconResourceId = R.drawable.bell, iconSize =
            35)


        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top
        ){
            CircleShapeComponent()

        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfWelcomePage(){
    WelcomePage()
}