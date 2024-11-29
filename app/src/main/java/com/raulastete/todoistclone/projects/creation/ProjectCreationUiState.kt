package com.raulastete.todoistclone.projects.creation

import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.entity.ProjectColor

data class ProjectCreationUiState(
    val projectName: String = "",
    val projectColor: ProjectColor = ProjectColor.RED,
    val parentProject: Project? = null,
    val isFavoriteProject: Boolean = false,
    val showProjectColorOptions: Boolean = false,
    val colors: List<ProjectColor> = ProjectColor.entries.toList(),
    val showProjectParentOptions: Boolean = false,
    val projects: List<Project> = emptyList()
)
