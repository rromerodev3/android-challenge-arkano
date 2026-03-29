package com.roy.rromeroarkanochallenge.presentation.ui.character

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.roy.rromeroarkanochallenge.presentation.viewmodel.CharactersViewModel
import com.roy.rromeroarkanochallenge.presentation.viewmodel.CharactersViewModel.UiState

@Composable
fun CharacterScreen(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (val currentSate = state) {
        is UiState.Loading -> LoadingContent()
        is UiState.Success -> CharacterList(characters =  currentSate.characters)
        is UiState.Error -> ErrorContent(onRetry = { viewModel.loadCharacters() })
    }
}