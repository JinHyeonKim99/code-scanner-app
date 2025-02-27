package com.androidproject.code_scanner_app.presentation.main_screen

import android.net.Uri

sealed interface MainScreenAction {
    data object OnCameraButtonClick : MainScreenAction
    data object OnGalleryButtonClick : MainScreenAction
    data object OnCopyButtonClick : MainScreenAction
}