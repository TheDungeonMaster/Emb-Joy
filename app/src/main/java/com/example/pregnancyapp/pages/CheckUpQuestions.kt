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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pregnancyapp.BooleanCheckUpQuestions
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
import com.example.pregnancyapp.ReusableText
import com.example.pregnancyapp.TextFieldCheckUpQuestion

@Composable
fun CheckUpQuestions(viewModel: CheckUpQuestionsViewModel, navController: NavController) {

    val state = viewModel.checkUpQuestionsState.collectAsState()
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldCheckUpQuestion(
                questionText = "How much do you weigh (kg) today?",
                iconInt = R.drawable.weight_scale_logo,
                onTextValueChange = { newValue -> viewModel.onWeightFieldChange(newValue) },
                textValue = state.value.weightField
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldCheckUpQuestion(
                "Please enter today's blood sugar (mmol/L) " +
                        "readings", R.drawable.blood_sugar_logo,
                onTextValueChange = { newValue -> viewModel.onBloodSugarChange(newValue) },
                textValue = state.value.bloodSugar
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldCheckUpQuestion(
                "Please enter today's blood pressure (mmHg) " +
                        "readings.", R.drawable.blood_pressure_logo,
                onTextValueChange = { newValue -> viewModel.onBloodPressureChange(newValue) },
                textValue = state.value.bloodPressure
            )



            Spacer(modifier = Modifier.height(20.dp))
            CheckupBooleanEntries(
                text = "Did you experience any swelling in your legs today?",
                iconInt = R.drawable.leg_swellings_logo,
                value = state.value.swellings,
                onTrueButtonClick = {viewModel.onSwellingsTrueButtonClick()},
                onFalseButtonClick = {viewModel.onSwellingsFalseButtonClick()}
            )
            Spacer(modifier = Modifier.height(20.dp))

            CheckupBooleanEntries(
                text = "Did you experience any bleedings?",
                iconInt = R.drawable.menstruation_logo,
                value = state.value.bleeding,
                onTrueButtonClick = {viewModel.onBleedingTrueButtonClick()},
                onFalseButtonClick = {viewModel.onBleedingFalseButtonClick()}
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextFieldCheckUpQuestion(
                "How do you feel today?", R.drawable.blood_pressure_logo,
                onTextValueChange = { newValue -> viewModel.onMoodChange(newValue) },
                textValue = state.value.mood.toString()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextFieldCheckUpQuestion(
                "Any other notes/comments?", R.drawable.blood_pressure_logo,
                onTextValueChange = { newValue -> viewModel.onCommentsChange(newValue) },
                textValue = state.value.comments.toString()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { viewModel.onSubmitButtonClick {
                // This block is called after the database operation completes
                navController.popBackStack()
            } },
                modifier = Modifier, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF63B8C3))
            ) {
                Text(
                    text = "Submit",
                    fontSize = 16.sp,

                )
            }

        }
    }
}


@Composable
fun CheckupBooleanEntries(
    text: String,
    iconInt: Int,
    value: Boolean,
    onTrueButtonClick: () -> Unit,
    onFalseButtonClick: () -> Unit
) {
    val yesColor = if (value) Color(0xFF63B8C3) else Color(0xFFEEEEEE)
    val noColor = if (value) Color(0xFFEEEEEE) else Color(0xFF63B8C3)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
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
                            Color(0xFF686161), Modifier
                        )
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
                                .background(yesColor)
                                .clickable { onTrueButtonClick() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Yes",
                                fontSize = 12.sp,
                                color = Color(0xFF686161),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(8.dp)) // Apply clipping with rounded corners
                                .background(noColor)
                                .clickable { onFalseButtonClick() }, // Then apply background
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

@Preview
@Composable
fun PreviewCheckUpQuestions() {
    CheckUpQuestions(viewModel(), rememberNavController())
}