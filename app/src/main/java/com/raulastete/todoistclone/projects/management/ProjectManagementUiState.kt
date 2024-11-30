package com.raulastete.todoistclone.projects.management

import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.entity.ProjectStatus

data class ProjectManagementUiState(
    val projects: List<Project> = listOf(Project(id = 1, name = "Project 1"), Project(id = 2, name = "Project 2")),
    val projectSearchQuery: String = "",
    val showProjectFilterOptions: Boolean = false,
    val projectStatus: ProjectStatus = ProjectStatus.ACTIVE

)