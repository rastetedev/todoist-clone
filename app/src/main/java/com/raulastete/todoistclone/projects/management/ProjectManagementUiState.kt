package com.raulastete.todoistclone.projects.management

import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.entity.ProjectStatus

data class ProjectManagementUiState(
    val projectList: List<Project> = emptyList(),
    val projectSearchQuery: String = "",
    val showProjectFilterOptions: Boolean = false,
    val projectStatus: ProjectStatus = ProjectStatus.ACTIVE

)