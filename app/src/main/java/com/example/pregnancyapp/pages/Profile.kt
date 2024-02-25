package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pregnancyapp.CustomBottomNavigationBar
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.authentication_logic.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController, authViewModel: AuthViewModel){

    val viewModel: PersonalDataViewModel = viewModel()
    val state = viewModel.userData.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFFF1F1F1))
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .padding()
            )
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                    ReusableIcon(
                        iconResourceId = R.drawable.profile_pic,
                        iconSize = 100,
                        scaleSize = 1.2f,
                        bottomPadding = 0
                    )

                Spacer(modifier = Modifier.width(50.dp))
                ReusableText(
                    text = state.value.name,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Top)
                        .size(40.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .width(350.dp)
                    .height(90.dp)
                    .clickable {
                        navController.navigate("personaldata")
                    }
                    .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableIcon(
                    iconResourceId = R.drawable.profile,
                    iconSize = 50,
                    scaleSize = 2f,
                    bottomPadding = 0
                )
                Spacer(modifier = Modifier.width(40.dp))

                ReusableText(
                    text = "Personal data",
                    color = Color(0xFFFAFAFA),
                    textStyle = MaterialTheme.typography.headlineMedium,
                    fontWeight = Normal,
                    modifier = Modifier.padding(bottom = 40.dp)
                )
            }

            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .height(90.dp)
                    .clickable {
                        navController.navigate("medicaldata")
                    }
                    .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableIcon(
                    iconResourceId = R.drawable.med_data,
                    iconSize = 50,
                    scaleSize = 2f,
                    bottomPadding = 0
                )
                Spacer(modifier = Modifier.width(40.dp))

                ReusableText(
                    text = "Medical data",
                    color = Color(0xFFFAFAFA),
                    textStyle = MaterialTheme.typography.headlineMedium,
                    fontWeight = Normal,
                    modifier = Modifier.padding(bottom = 40.dp)
                )
            }


            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .clickable { }
                    .height(90.dp)
                    .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableIcon(
                    iconResourceId = R.drawable.settings_key,
                    iconSize = 50,
                    scaleSize = 2f,
                    bottomPadding = 0
                )
                Spacer(modifier = Modifier.width(40.dp))

                ReusableText(
                    text = "Settings",
                    color = Color(0xFFFAFAFA),
                    textStyle = MaterialTheme.typography.headlineMedium,
                    fontWeight = Normal,
                    modifier = Modifier.padding(bottom = 40.dp)
                )

            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            )
        CustomBottomNavigationBar(
            navController = navController, R.drawable
                .union, R.drawable.bot_icon, R.drawable
                .profile_active, Modifier, Color(0xFFF1F1F1)
        )

        }


    }

