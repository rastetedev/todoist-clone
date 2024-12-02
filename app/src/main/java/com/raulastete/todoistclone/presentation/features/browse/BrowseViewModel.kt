package com.raulastete.todoistclone.presentation.features.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raulastete.todoistclone.domain.repository.ProjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BrowseViewModel(private val projectRepository: ProjectRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(BrowseUiState())
    val uiState = _uiState.asStateFlow()
        .onStart { loadProjects() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), BrowseUiState())

    private fun loadProjects(){
        viewModelScope.launch {
           projectRepository.observeProjects().collectLatest { projects ->
               _uiState.update {
                   it.copy(projectList = projects)
               }
           }
        }
    }

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