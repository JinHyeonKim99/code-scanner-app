package com.androidproject.code_scanner_app.presentation.main_screen

import com.androidproject.code_scanner_app.domain.model.Code

data class MainScreenState(
    val code: Code = Code(0,"``````"),
    val codeHistory: List<Code> = emptyList(),
    val isAnswer: Boolean = false,
    val isHistory: Boolean = false,
    val isLoading: Boolean = false
)