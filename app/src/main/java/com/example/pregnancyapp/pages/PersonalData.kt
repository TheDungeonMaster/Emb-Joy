package com.example.pregnancyapp.pages

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.AuthViewModel

@Composable
fun PersonalData(navController: NavController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Name, Surname",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = (AuthService.getCurrentUser()?.nameSurname.toString()),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Day of pregnancy",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = (AuthService.getCurrentUser()?.dayOfPregnancy.toString()),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Weight (kg)",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = AuthService.getCurrentUser()?.weight.toString(),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Height (cm)",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = (AuthService.getCurrentUser()?.height.toString()),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Previous pregnancies",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = (AuthService.getCurrentUser()?.numOfPregnancies.toString()),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ReusableText(
                text = "Failed pregnancies",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))

            ReusableText(
                text = (AuthService.getCurrentUser()?.numOfFailedPregnancies.toString()),
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 20.dp)
                    .weight(1f)
            )
        }
        Button(
            onClick = { navController.popBackStack()},
            modifier = Modifier
                .padding(start = 15.dp, top = 10.dp)
                .size(70.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color
                .Transparent),
        )
        {
            ReusableIcon(
                iconResourceId = R.drawable.back_arrow,
                iconSize = 100,
                scaleSize = 1.8f,
                bottomPadding = 0
            )
        }

    }
}
