package com.androidproject.code_scanner_app.presentation.main_screen

import com.androidproject.code_scanner_app.domain.model.Code

data class MainScreenState(
    val code: Code = Code("No Language", "No Code"),
    val isAnswer: Boolean = false,
)