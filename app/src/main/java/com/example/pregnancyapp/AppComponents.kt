package com.example.pregnancyapp.login_register.components


import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.graphics.toColorInt
import com.example.pregnancyapp.R

@Composable
fun NormalTextComponent(value: String, textSize: Int){
    Text(
        text = value,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 20.dp),
        style = TextStyle(
            fontSize = textSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default

        )

    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default

        )

    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(
    labelValue: String,
    painterResource: Painter,
    textValue: String,
    onTextValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = textValue,
        onValueChange = { onTextValueChange(it) },
        label = {
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = labelValue)
            }
        },
        singleLine = true,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                // Handle "Next" action if needed
            }
        ),
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableText(
    text: String,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    color: Color
) {
    Text(
        text = text,
        style = textStyle.copy(fontWeight = fontWeight, color = color),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableTextCentered(
    text: String,
    textStyle: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    color: Color,
) {
    Text(
        text = text,
        style = textStyle.copy(fontWeight = fontWeight, color = color),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ReusableIcon(iconResourceId: Int, iconSize: Int, scaleSize: Float,
                 bottomPadding: Int) {
    val painter = painterResource(id = iconResourceId)

    Box(
        modifier = Modifier
            .size(iconSize.dp)
            .scale(scaleSize)
            .padding(bottom = bottomPadding.dp) ,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = null, // No content description
            tint = Color.Unspecified // No tint

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleWhiteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colorScheme.onSecondary,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
    )
}


@Composable
fun CircleShapeComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.65f)
            .background(
                Color(android.graphics.Color.parseColor("#64BCB9")),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center // Center the content inside the Box
    ) {
        ReusableIcon(iconResourceId = R.drawable.baby_embryo, iconSize = 130,
            scaleSize = 2.5f, 20)


        ReusableText(text = "6 weeks 1 day", MaterialTheme.typography
            .headlineMedium, Bold, Color.White)
        ReusableText(text = "237 days left", MaterialTheme.typography
            .headlineMedium, Normal, Color.White)





    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextFieldComponent(
    labelValue: String,
    painter: Painter,
    textValue: String,
    onTextValueChange: (String) -> Unit,
){
    var isValidEmail by remember { mutableStateOf(true) }

    if (!isValidEmail && textValue.isNotEmpty()) {
        Text(
            text = "Invalid email format",
            color = Color.Red,
            modifier = Modifier.padding(top = 4.dp)
        )
    } else if(textValue.isEmpty()){
        isValidEmail = true
    }

    OutlinedTextField(
        value = textValue,
        onValueChange = { onTextValueChange(it) },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null, // Provide a meaningful content description
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
    )
}

fun isValidEmail(email: String): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(
    labelValue: String,
    painter: Painter,
    textValue: String,
    onTextValueChange: (String) -> Unit,
){
    val password = remember{
        mutableStateOf("")
    }

    val passwordVisible = remember{
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textValue,
        onValueChange = { onTextValueChange(it) },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null, // Provide a meaningful content description
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
    )
}


@Composable
fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = CenterVertically,
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            })

        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color =
        Color.Black)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color =
        Color.Black)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation =
            termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponentCustomColor(value: String,  onClick: () -> Unit, color:
Color,
                    textColor: Color) {

    val coroutineScope = rememberCoroutineScope()
    val isClicked = remember { mutableStateOf(false) }
    val buttonColor = if (isClicked.value) Color(0xFF75BFCB) else textColor

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center

    ) {
        ElevatedButton(
            modifier = Modifier
            ,
            contentPadding = PaddingValues(),
            onClick = onClick,

            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value,
                    fontSize = 18.sp,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ButtonComponentConstColor(value: String,  onClick: () -> Unit) {

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center

    ) {
        ElevatedButton(
            modifier = Modifier
            ,
            contentPadding = PaddingValues(),
            onClick = onClick,

            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF75BFCB))
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TextFieldCheckUpQuestion(){

    var enteredText by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFFF9F9F9))
            .padding(10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // First Column for the Icon
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Replace the content inside this Column with your icon
                ReusableIcon(
                    iconResourceId = R.drawable.weight_scale_logo,
                    iconSize = 100,
                    scaleSize = 0.75f,
                    bottomPadding = 0
                )
            }

            // Second Column for the Text and TextField
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Text
                ReusableText("How much do you weigh today?", MaterialTheme
                    .typography.bodyLarge, Bold, Color.Gray)
            }
        }

    }
}

@Preview
@Composable
fun PreviewTextFieldCheckUpQuestion(){
    TextFieldCheckUpQuestion()
}
