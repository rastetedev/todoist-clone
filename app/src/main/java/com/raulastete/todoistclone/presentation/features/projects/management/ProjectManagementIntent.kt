package com.raulastete.todoistclone.presentation.features.projects.management

import com.raulastete.todoistclone.domain.entity.ProjectStatus

sealed interface ProjectManagementIntent {

    data class SearchQueryChange(val query: String) : ProjectManagementIntent
    data object Search : ProjectManagementIntent
    data object ToggleProjectStatusOptions : ProjectManagementIntent
    data class ChangeProjectStatusFilter(val projectStatus: ProjectStatus) : ProjectManagementIntent
}