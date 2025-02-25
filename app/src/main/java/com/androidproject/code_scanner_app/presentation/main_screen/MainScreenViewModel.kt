package com.androidproject.code_scanner_app.presentation.main_screen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidproject.code_scanner_app.domain.repository.CodeRepository
import com.androidproject.code_scanner_app.domain.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val codeRepository: CodeRepository,
    private val imageRepository: ImageRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: MainScreenAction) {
        when (action) {
            is MainScreenAction.OnCameraButtonClick -> {}
            is MainScreenAction.OnGalleryButtonClick -> {}
        }
    }

    init {
        fetchCode()
    }

    private fun fetchCode() {
        viewModelScope.launch {
            _state.emit(
                MainScreenState()
            )
        }
    }

    fun onCameraButtonClick(uri: Uri) {
        viewModelScope.launch {

            _state.update {
                MainScreenState(
                    code = codeRepository.getCode(" 이 이미지에 어떤게 있는지 파이썬 기능을 사용하지 말고 알려줄래? 만약 프로그래밍 코드라면 코드만 알려줘", uri),
                    isAnswer = true
                )
            }
        }
    }

    fun onGalleryButtonClick(uri: Uri) {
        viewModelScope.launch {

            _state.update {
                MainScreenState(
                    code = codeRepository.getCode(" 이 이미지에 어떤게 있는지 파이썬 기능을 사용하지 말고 알려줄래? 만약 프로그래밍 코드라면 코드만 알려줘", uri),
                    isAnswer = true
                )
            }
        }
    }
}