package com.raulastete.todoistclone.presentation.features.settings.navigationbar

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationBarConfigViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(NavigationBarConfigUiState())
    val uiState: StateFlow<NavigationBarConfigUiState> = _uiState.asStateFlow()

    fun onIntent(intent: NavigationBarConfigIntent) {
        when (intent) {
            is NavigationBarConfigIntent.ChangeDynamicAddButtonPlacement -> {

            }
        }
    }
}