package com.androidproject.code_scanner_app.presentation.main_screen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidproject.code_scanner_app.domain.model.Code
import com.androidproject.code_scanner_app.domain.repository.CodeHistoryRepository
import com.androidproject.code_scanner_app.domain.repository.CodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val codeRepository: CodeRepository,
    private val codeHistoryRepository: CodeHistoryRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: MainScreenAction) {
        when (action) {
            is MainScreenAction.OnCameraButtonClick -> {}

            is MainScreenAction.OnGalleryButtonClick -> {}

            is MainScreenAction.OnCopyButtonClick -> {}

            is MainScreenAction.OnShareButtonClick -> {}

            is MainScreenAction.OnBackButtonClick -> {
                onBackButtonClick()
            }

            is MainScreenAction.OnDeleteButtonClick -> {
                onDeleteButtonClick(action.id)
            }

            is MainScreenAction.OnHistoryButtonClick -> {
                onHistoryButtonClick()
            }

            MainScreenAction.OnDeleteAllButton -> {
                onDeleteAllButtonClick()
            }

            is MainScreenAction.OnCodeButtonCLick -> {
                onCodeButtonClick(action.id)
            }
        }
    }

    init {
        fetchCode()
    }

    private fun fetchCode() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    codeHistory = codeHistoryRepository.getAllCodeHistory()
                )
            }
        }
    }

    fun onCameraButtonClick(uri: Uri) {
        viewModelScope.launch {
            _state.update { mainScreenState ->
                mainScreenState.copy(
                    isAnswer = true,
                    isLoading = true
                )
            }

            val code = codeRepository.getCode(
                " 이 이미지에 어떤게 있는지 파이썬 기능을 사용하지 말고 알려줄래? 만약 프로그래밍 코드라면 코드만 알려줘",
                uri
            )

            _state.update { mainScreenState ->
                mainScreenState.copy(
                    code = code,
                    isLoading = false
                )
            }

            saveCode(code.copy(id = codeHistoryRepository.getCodeCount() + 1))
        }
    }

    fun onGalleryButtonClick(uri: Uri) {
        viewModelScope.launch {
            _state.update { mainScreenState ->
                mainScreenState.copy(
                    isAnswer = true,
                    isHistory = false,
                    isLoading = true
                )
            }

            val code = codeRepository.getCode(
                " 이 이미지가 프로그래밍 코드라면 코드만 마크다운으로 알려줘",
                uri
            )

            _state.update { mainScreenState ->
                mainScreenState.copy(
                    code = code,
                    isLoading = false
                )
            }

            saveCode(code.copy(id = codeHistoryRepository.getCodeCount() + 1))
        }
    }

    private fun onBackButtonClick() {
        viewModelScope.launch {
            _state.update { mainScreenState ->
                mainScreenState.copy(
                    isAnswer = if (_state.value.isAnswer) false else _state.value.isAnswer,
                    isHistory = _state.value.isAnswer && _state.value.isHistory,
                )
            }
        }
    }

    private fun onHistoryButtonClick() {
        viewModelScope.launch {
            _state.update { mainScreenState ->
                mainScreenState.copy(
                    codeHistory = codeHistoryRepository.getAllCodeHistory(),
                    isHistory = true
                )
            }
        }
    }

    private fun onCodeButtonClick(id: Int) {
        viewModelScope.launch {
            println(id)
            _state.update { mainScreenState ->
                mainScreenState.copy(
                    isAnswer = true,
                    code = codeHistoryRepository.getCodeHistoryById(id)
                )
            }
        }
    }

    private fun onDeleteButtonClick(id: Int) {
        viewModelScope.launch {
            codeHistoryRepository.deleteHistoryById(id)

            _state.update { mainScreenState ->
                mainScreenState.copy(
                    codeHistory = codeHistoryRepository.getAllCodeHistory()
                )
            }
        }
    }

    private fun onDeleteAllButtonClick() {
        viewModelScope.launch {
            codeHistoryRepository.deleteAllHistory()

            _state.update { mainScreenState ->
                mainScreenState.copy(
                    codeHistory = codeHistoryRepository.getAllCodeHistory()
                )
            }
        }
    }

    private suspend fun saveCode(code: Code) {
        codeHistoryRepository.updateHistory(code)
    }
}