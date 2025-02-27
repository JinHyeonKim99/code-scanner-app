package com.androidproject.code_scanner_app.presentation.main_screen

sealed interface MainScreenAction {
    data object OnCameraButtonClick : MainScreenAction
    data object OnGalleryButtonClick : MainScreenAction
    data object OnCopyButtonClick : MainScreenAction
    data object OnShareButtonClick : MainScreenAction
    data object OnBackButtonClick : MainScreenAction
}