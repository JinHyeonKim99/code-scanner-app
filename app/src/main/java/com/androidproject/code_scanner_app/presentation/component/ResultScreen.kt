package com.androidproject.code_scanner_app.presentation.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidproject.code_scanner_app.presentation.main_screen.MainScreenState

@Composable
fun ResultScreen(
    modifier: Modifier,
    state: MainScreenState,
    isLandscape: Boolean = false
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "결과",
            fontSize = 30.sp,
            color = Color.LightGray,
            modifier = Modifier
        )
        Text(
            text = state.code.code,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(
                    start = if (isLandscape) 40.dp else 15.dp,
                    top = 30.dp,
                    bottom = 50.dp
                )
                .horizontalScroll(
                    state = rememberScrollState()
                )
                .verticalScroll(
                    state = rememberScrollState()
                ),
        )
    }
}