package com.androidproject.code_scanner_app.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.androidproject.code_scanner_app.presentation.component.ReadyScanScreen
import com.androidproject.code_scanner_app.presentation.component.ResultScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    state: MainScreenState = MainScreenState(),
    isLandscape: Boolean = false,
    onAction: (MainScreenAction) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        if (state.isAnswer) {
            ResultScreen(
                modifier = Modifier.align(Alignment.Center),
                state = state,
                isLandscape = isLandscape,
                onAction = onAction
            )
        } else {
            ReadyScanScreen(
                modifier = Modifier.align(Alignment.Center),
                isLandscape = isLandscape,
                onAction = onAction
            )
        }
    }
}

