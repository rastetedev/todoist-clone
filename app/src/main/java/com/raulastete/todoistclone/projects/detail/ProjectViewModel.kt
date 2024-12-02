package com.raulastete.todoistclone.projects.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raulastete.todoistclone.domain.repository.ProjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProjectViewModel(
    private val projectRepository: ProjectRepository,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProjectUiState())

    val uiState = _uiState
        .onStart { loadProject() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ProjectUiState()
        )

    private fun loadProject() {
        viewModelScope.launch {
            val project = projectRepository.getProject(savedStateHandle.get<Long>(PROJECT_ID_KEY) ?: 0)
            _uiState.update {
                it.copy(
                    projectId = project.id,
                    projectName = project.name
                )
            }
        }
    }
}