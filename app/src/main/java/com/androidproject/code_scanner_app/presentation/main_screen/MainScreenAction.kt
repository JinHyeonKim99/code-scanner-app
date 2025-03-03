package com.androidproject.code_scanner_app.presentation.main_screen

sealed interface MainScreenAction {
    data object OnCameraButtonClick : MainScreenAction
    data object OnGalleryButtonClick : MainScreenAction
    data object OnCopyButtonClick : MainScreenAction
    data object OnShareButtonClick : MainScreenAction
    data object OnBackButtonClick : MainScreenAction
    data object OnHistoryButtonClick : MainScreenAction
    data class OnCodeButtonCLick(val id: Int) : MainScreenAction
    data class OnDeleteButtonClick(val id: Int) : MainScreenAction
    data object OnDeleteAllButton : MainScreenAction
}