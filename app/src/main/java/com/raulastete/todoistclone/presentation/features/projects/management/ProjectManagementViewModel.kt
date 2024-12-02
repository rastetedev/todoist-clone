package com.raulastete.todoistclone.presentation.features.projects.management

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

class ProjectManagementViewModel(
    private val projectRepository: ProjectRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProjectManagementUiState())
    val uiState = _uiState.asStateFlow()
        .onStart { loadProjects() }
        .stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000L), ProjectManagementUiState()
        )

    private fun loadProjects() {
        viewModelScope.launch {
            projectRepository.observeProjects().collectLatest { projects ->
                _uiState.update {
                    it.copy(projectList = projects)
                }
            }
        }
    }

    fun onIntent(intent: ProjectManagementIntent) {
        when (intent) {
            is ProjectManagementIntent.ChangeProjectStatusFilter -> {
                _uiState.update {
                    it.copy(projectStatus = intent.projectStatus)
                }
            }

            ProjectManagementIntent.Search -> {
                _uiState.update {
                    it.copy(
                        projectList = it.projectList.filter { project ->
                            project.name.contains(it.projectSearchQuery, ignoreCase = true)
                        }
                    )
                }
            }

            is ProjectManagementIntent.SearchQueryChange -> {
                _uiState.update {
                    it.copy(projectSearchQuery = intent.query)
                }
            }

            ProjectManagementIntent.ToggleProjectStatusOptions -> {
                _uiState.update {
                    it.copy(showProjectFilterOptions = it.showProjectFilterOptions.not())
                }
            }
        }
    }
}