package com.raulastete.todoistclone.presentation.features.projects.creation

import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.entity.ProjectColor

interface ProjectCreationIntent {
    data object CreateProject : ProjectCreationIntent
    data class ProjectNameChange(val projectName: String) : ProjectCreationIntent
    data object ToggleColorOptions : ProjectCreationIntent
    data object ToggleProjectList : ProjectCreationIntent
    data object ToggleFavoriteOption : ProjectCreationIntent
    data class ChangeProjectColor(val projectColor: ProjectColor) : ProjectCreationIntent
    data class ChangeParentProject(val parentProject: Project) : ProjectCreationIntent
}

sealed interface ProjectCreationEvent {
    data class ProjectCreated(val projectId: Long) : ProjectCreationEvent
}