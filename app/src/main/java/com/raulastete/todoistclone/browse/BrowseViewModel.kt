package com.raulastete.todoistclone.browse

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BrowseViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BrowseUiState())
    val uiState: StateFlow<BrowseUiState> = _uiState.asStateFlow()

    fun onIntent(intent: BrowseIntent) {
        when (intent) {
            BrowseIntent.ToggleProjectVisibility -> {
                _uiState.update {
                    it.copy(
                        showProjects = !it.showProjects
                    )
                }
            }
        }
    }
}