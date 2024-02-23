package com.example.pregnancyapp.calendar


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@Composable
fun Calendar(
    modifier: Modifier = Modifier,

    ) {
    val dataSource: CalendarDataSource = viewModel()
    var calendarUiModel by dataSource.calendarUiModel



    Column(
        modifier = modifier
            .fillMaxWidth()
             ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            data = calendarUiModel ,
            onBackButtonClick = { startDate ->
                // refresh the CalendarUiModel with new data
                // by get data with new Start Date (which is the startDate-1 from the visibleDates)
                val finalStartDate = startDate.minusDays(1)
                calendarUiModel = dataSource.getData(
                    startDate = finalStartDate ,
                    lastSelectedDate = calendarUiModel.selectedDate.date
                )
            } ,
            onForwardButtonClick = { endDate ->
                // refresh the CalendarUiModel with new data
                // by get data with new Start Date (which is the endDate+2 from the visibleDates)
                val finalStartDate = endDate.plusDays(2)
                calendarUiModel = dataSource.getData(
                    startDate = finalStartDate ,
                    lastSelectedDate = calendarUiModel.selectedDate.date
                )
            }
        )
        Content(data = calendarUiModel , onDateClickListener = { date ->
            // refresh the CalendarUiModel with new data
            // by changing only the `selectedDate` with the date selected by User
            calendarUiModel = calendarUiModel.copy(
                selectedDate = date ,
                visibleDates = calendarUiModel.visibleDates.map {
                    it.copy(
                        isSelected = it.date.isEqual(date.date)
                    )
                }
            )

        })
    }
}


@Composable
fun Header(
    data: CalendarUiModel ,
    onForwardButtonClick: (LocalDate) -> Unit ,
    onBackButtonClick: (LocalDate) -> Unit ,
    modifier: Modifier = Modifier

) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (data.selectedDate.isToday) {
                "Today"
            } else {
                data.selectedDate.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            } ,
            fontSize = 16.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.weight(1f)

        )
        IconButton(onClick = { onBackButtonClick(data.startDate.date) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft ,
                contentDescription = "Previous"
            )
        }
        IconButton(onClick = { onForwardButtonClick(data.endDate.date) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight ,
                contentDescription = "Next" ,
            )
        }
    }
}


@Composable
fun ContentItem(
    date: CalendarUiModel.Date ,
    onClickListener: (CalendarUiModel.Date) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp , horizontal = 4.dp)
            .clickable { // making the element clickable, by adding 'clickable' modifier
                onClickListener(date)
            } ,
        colors = CardDefaults.cardColors(
            // background colors of the selected date
            // and the non-selected date are different
            containerColor = if (date.isSelected) {
                Color(0xff61B6C3)
            } else {
                Color(0xffEEEEEE)
            } ,
        )
    ) {
        Column(
            modifier = Modifier
                .width(42.dp)
                .height(48.dp)
                .padding(4.dp)
        ) {
            Text(
                text = date.day ,
                modifier = Modifier.align(Alignment.CenterHorizontally) ,
                fontSize = 12.sp
            )
            Text(
                text = date.date.dayOfMonth.toString() ,
                modifier = Modifier.align(Alignment.CenterHorizontally) ,
                fontSize = 16.sp
            )
        }
    }
}


@Composable
fun Content(
    data: CalendarUiModel ,
    onDateClickListener: (CalendarUiModel.Date) -> Unit ,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        LazyRow {
            items(items = data.visibleDates) { date ->
                ContentItem(date , onDateClickListener)
            }
        }
    }

}


@Preview
@Composable
fun ItemPreview() {
//    Content()
}

@Preview
@Composable
fun CalendarPreview() {
//    Header({} , {})
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Calendar()
}