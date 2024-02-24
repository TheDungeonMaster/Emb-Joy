package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReusableComposeNode
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText

@Composable
fun LogoWelcomePage(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE0F8FB),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReusableIcon(
                iconResourceId = R.drawable.embjoy_logo,
                iconSize = 100,
                scaleSize = 3.2f,
                bottomPadding = 8
            )

            Spacer(modifier = Modifier.height(120.dp)) // Adjust the height as
            // needed

            ReusableIcon(
                iconResourceId = R.drawable.embryo_journey_text,
                iconSize = 100,
                scaleSize = 1.6f,
                bottomPadding = 8
            )
            Spacer(modifier = Modifier.height(120.dp))
            Row() {
                Button(
                    onClick = {navController.navigate("login")},
                    modifier = Modifier
                        .padding(start = 15.dp, top = 10.dp)
                        .height(70.dp)
                        .width(130.dp),

                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                )
                {

                    ReusableText(
                        text = "LOG IN",
                        MaterialTheme.typography.headlineSmall,
                        color = Color.Black,
                        modifier = Modifier
                    )
                }
                Button(
                    onClick = {navController.navigate("signup")},
                    modifier = Modifier
                        .padding(start = 15.dp, top = 10.dp)
                        .height(70.dp)
                        .width(160.dp),

                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                )
                {

                    ReusableText(
                        text = "REGISTER",
                        MaterialTheme.typography.headlineSmall,
                        color = Color.Black,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
