package com.raulastete.todoistclone.projects.creation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProjectCreationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProjectCreationUiState())
    val uiState: StateFlow<ProjectCreationUiState> = _uiState.asStateFlow()

    fun onIntent(intent: ProjectCreationIntent) {
        when (intent) {
            ProjectCreationIntent.CreateProject -> {
                //TODO: Implement when repository is implemented
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