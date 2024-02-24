package com.example.pregnancyapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancyapp.BooleanButtonComponent
import com.example.pregnancyapp.BooleanCheckUpQuestions
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.SimpleWhiteTextField
import com.example.pregnancyapp.TextFieldCheckUpQuestion



@Composable
fun JournalScreen(
    weight: String,
    bloodSugar: String,
    bloodPressure: String,
    legSwellings: Boolean,
    bleeding: Boolean,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ){
            JournalEntry("Weight", R
                .drawable.weight_scale_logo, weight)
            Spacer(modifier = Modifier.height(20.dp))
            JournalEntry("Blood sugar", R.drawable.blood_sugar_logo, bloodSugar)
            Spacer(modifier = Modifier.height(20.dp))
            JournalEntry("Blood pressure", R.drawable.blood_pressure_logo, bloodPressure)
            Spacer(modifier = Modifier.height(20.dp))
            JournalBooleanEntries(
                text = "Did you experience any swelling in your legs today?",
                iconInt = R.drawable.leg_swellings_logo,
                value = legSwellings
            )
            Spacer(modifier = Modifier.height(20.dp))
            JournalBooleanEntries(
                text = "Did you experience any bleeding today?",
                iconInt = R.drawable.menstruation_logo,
                value = bleeding
            )
        }
    }
}



@Composable
fun JournalBooleanEntries(text: String, iconInt: Int, value: Boolean) {
    val yesColor = if (value) Color(0xFF63B8C3) else Color(0xFFEEEEEE)

    val noColor = if (value)Color(0xFFEEEEEE) else Color(0xFF63B8C3)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF6F6F6)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // First Column for the Icon
            Column(
                modifier = Modifier
                    .padding(8.dp)

                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Replace the content inside this Column with your icon
                ReusableIcon(
                    iconResourceId = iconInt,
                    iconSize = 100,
                    scaleSize = 0.7f,
                    bottomPadding = 0
                )
            }

            // Second Column for the Text and Buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Start)
                    ) {
                        ReusableText(
                            text,
                            MaterialTheme.typography.labelSmall,
                            FontWeight.Bold,
                            Color(0xFF686161) ,Modifier)
                    }

                    // Row to place the two buttons next to each other
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)

                    ) {
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(8.dp)) // Apply clipping with rounded corners
                                .background(yesColor), // Then apply background
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Yes",
                                fontSize = 12.sp,
                                color = Color(0xFF686161),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(8.dp)) // Apply clipping with rounded corners
                                .background(noColor), // Then apply background
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No",
                                fontSize = 12.sp,
                                color = Color(0xFF686161),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun JournalEntry(text: String, iconInt: Int, value: String) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F6F6)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // First Column for the Icon
                ReusableIcon(
                    iconResourceId = iconInt,
                    iconSize = 100,
                    scaleSize = 0.7f,
                    bottomPadding = 0
                )

                // Second Column for the Text and TextField
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    ReusableText(
                        text,
                        MaterialTheme.typography.labelSmall,
                        FontWeight.Bold,
                        Color(0xFF686161) ,Modifier)
                    Text(
                        text = value,
                        fontSize = 16.sp,
                        color = Color(0xFF686161)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun EntityPreview() {
    JournalEntry("How much do you weigh today?", R
        .drawable.weight_scale_logo, "80kg")
}

@Preview
@Composable
fun JournalPreview() {
    JournalScreen(
        "80kg",
        "190ml",
        "180ml",
        true,
        false
    )
}