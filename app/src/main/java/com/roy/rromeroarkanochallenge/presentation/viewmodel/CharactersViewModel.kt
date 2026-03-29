package com.roy.rromeroarkanochallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roy.rromeroarkanochallenge.domain.model.Character
import com.roy.rromeroarkanochallenge.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.onFailure
import kotlin.onSuccess
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    sealed class UiState {
        object Loading: UiState()
        data class Success(val characters: List<Character>): UiState()
        data class Error(val message: String): UiState()
    }

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            delay(3.seconds)
            getCharactersUseCase()
                .onSuccess { characters ->
                    _state.value = UiState.Success(characters = characters)
                }
                .onFailure { error ->
                    _state.value = UiState.Error(error.message ?: "Something went wrong")
                }
        }
    }
}