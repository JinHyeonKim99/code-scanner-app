package com.example.code_scanner_app.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code_scanner_app.domain.model.Image
import com.example.code_scanner_app.domain.repository.CodeRepository
import com.example.code_scanner_app.domain.repository.ImageRepository
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

    fun onButtonClick() {
        viewModelScope.launch {
            _state.update {
                MainScreenState(
                    code = codeRepository.getCode(),
                    isAnswer = true
                )
            }
        }
    }
}