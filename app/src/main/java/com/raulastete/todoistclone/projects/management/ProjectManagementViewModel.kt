package com.raulastete.todoistclone.projects.management

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProjectManagementViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProjectManagementUiState())
    val uiState: StateFlow<ProjectManagementUiState> = _uiState.asStateFlow()

    fun onIntent(intent: ProjectManagementIntent) {
        when(intent){
            is ProjectManagementIntent.ChangeProjectStatusFilter -> TODO()
            ProjectManagementIntent.Search -> TODO()
            is ProjectManagementIntent.SearchQueryChange -> TODO()
            ProjectManagementIntent.ToggleProjectStatusOptions -> TODO()
        }
    }
}