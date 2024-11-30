package com.raulastete.todoistclone.settings.navigationbar

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationBarViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(NavigationBarUiState())
    val uiState: StateFlow<NavigationBarUiState> = _uiState.asStateFlow()

    fun onIntent(intent: NavigationBarIntent) {
        when (intent) {
            is NavigationBarIntent.ChangeDynamicAddButtonPlacement -> {

            }
        }
    }
}