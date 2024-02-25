package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.authentication_logic.AuthService
import com.example.pregnancyapp.authentication_logic.AuthViewModel


@Composable
fun MedicalData(navController: NavController, authViewModel: AuthViewModel) {
    var textColor = Color.Black
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val user = AuthService.getCurrentUser()

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .width(350.dp)
                .height(90.dp)
                .background(Color(0xFF75BFCB), RoundedCornerShape(20.dp))
                .padding(start = 20.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Align children with space in between
            verticalAlignment = Alignment.CenterVertically
        ) {
            ReusableText(
                text = "Diabetes",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            if (user != null) {
                ReusableText(
                    text = getMedicalConditionStatus(user.hasDiabetes),
                    color = getColor(getMedicalConditionStatus(user
                        .hasDiabetes)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }
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
                text = "High Blood Pressure",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            if (user != null) {
                ReusableText(
                    text = getMedicalConditionStatus(user.hasHighBloodPressure),
                    color = getColor(getMedicalConditionStatus(user
                        .hasHighBloodPressure)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }
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
                text = "Fertility Issues",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            if (user != null) {
                ReusableText(
                    text = getMedicalConditionStatus(user.hasFertilityIssues),
                    color = getColor(getMedicalConditionStatus(user
                        .hasFertilityIssues)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }
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
                text = "Mental Conditions.",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            if (user != null) {
                ReusableText(
                    text = getMedicalConditionStatus(user.hasMentalHealthConditions),
                    color = getColor(getMedicalConditionStatus(user
                        .hasMentalHealthConditions)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }
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
                text = "Obesity",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            if (user != null) {
                ReusableText(
                    text = getMedicalConditionStatus(user.hasObesity),
                    color = getColor(getMedicalConditionStatus(user
                        .hasObesity)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }
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
                text = "Other conditions",
                color = Color(0xFFFAFAFA),
                textStyle = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.width(40.dp))

            if (user != null) {

                ReusableText(
                    text = getMedicalConditionStatus(user.hasOtherCondition),
                    color = getColor(getMedicalConditionStatus(user.hasOtherCondition)),
                    textStyle = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, end = 20.dp)
                        .weight(1f)
                )
            }

        }
        Spacer(modifier = Modifier.weight(1f))

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

fun getMedicalConditionStatus(result : Boolean) : String {
    return if(result){
        "Yes"
    } else {
        "No"
    }
}

fun getColor(yesNoForMedCondition: String) : Color{
    return if(yesNoForMedCondition == "Yes"){
        Color(0xFFFFA200)
    } else {
        Color.White
    }
}
