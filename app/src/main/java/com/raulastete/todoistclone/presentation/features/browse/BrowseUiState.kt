package com.raulastete.todoistclone.presentation.features.browse

import com.raulastete.todoistclone.domain.entity.Project

data class BrowseUiState(
    val username: String = "",
    val inboxQuantity: String = 0.toString(),
    val projectList: List<Project> = emptyList(),
    val showProjects: Boolean = true
)