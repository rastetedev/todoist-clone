package com.raulastete.todoistclone.projects.creation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.repository.ProjectRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProjectCreationViewModel(
    private val projectRepository: ProjectRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProjectCreationUiState())
    val uiState: StateFlow<ProjectCreationUiState> = _uiState.asStateFlow()

    private val _events = Channel<ProjectCreationEvent>()
    val events = _events.receiveAsFlow()

    fun onIntent(intent: ProjectCreationIntent) {
        when (intent) {
            ProjectCreationIntent.CreateProject -> {
                viewModelScope.launch {
                    val projectId = projectRepository.createProject(
                        Project(
                            name = uiState.value.projectName,
                            parentProjectId = uiState.value.parentProject?.id ?: 0L,
                            isFavorite = uiState.value.isFavoriteProject,
                            color = uiState.value.projectColor
                        )
                    )

                    _events.send(ProjectCreationEvent.ProjectCreated(projectId))
                }
            }

            is ProjectCreationIntent.ProjectNameChange ->
                _uiState.update { it.copy(projectName = intent.projectName) }

            ProjectCreationIntent.ToggleColorOptions ->
                _uiState.update {
                    it.copy(
                        showProjectColorOptions = uiState.value.showProjectColorOptions.not()
                    )
                }

            ProjectCreationIntent.ToggleProjectList ->
                _uiState.update {
                    it.copy(
                        showProjectParentOptions = uiState.value.showProjectParentOptions.not()
                    )
                }

            ProjectCreationIntent.ToggleFavoriteOption ->
                _uiState.update {
                    it.copy(isFavoriteProject = _uiState.value.isFavoriteProject.not())
                }

            is ProjectCreationIntent.ChangeProjectColor ->
                _uiState.update { it.copy(projectColor = intent.projectColor) }

            is ProjectCreationIntent.ChangeParentProject ->
                _uiState.update {
                    it.copy(
                        parentProject = uiState.value.projects.find { project ->
                            project.id == intent.parentProject.id
                        }
                    )
                }
        }
    }
}