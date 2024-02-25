package com.example.pregnancyapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.pregnancyapp.authentication_logic.AuthViewModel


@Composable
fun CustomBottomNavigationBar(navController: NavController, colorId1: Int,
                              colorId2: Int, colorId3: Int, modifier:
                              Modifier = Modifier, barColor: Color) {

    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = barColor
    ){
        Row(
            modifier = Modifier
                .height(70.dp)
                .background(Color.Transparent)
                .zIndex(1f)
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            NavButton(
                iconResourceId = colorId1,
                iconSize = 24,
                scaleSize = 1.2f,
                bottomPadding = 0,
                onClick = {navController.navigate("welcome")}
            )

            NavButton(
                iconResourceId = colorId2,
                iconSize = 24,
                scaleSize = 1.2f,
                bottomPadding = 0,
                onClick = {navController.navigate("chat")}
            )

            NavButton(
                iconResourceId = colorId3,
                iconSize = 24,
                scaleSize = 1.2f,
                bottomPadding = 0,
                onClick = {navController.navigate("profile")}
            )
        }
    }

}




