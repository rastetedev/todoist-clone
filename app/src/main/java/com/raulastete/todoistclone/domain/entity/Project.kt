package com.raulastete.todoistclone.domain.entity

data class Project(
    val id: Int = 0,
    val name: String,
    val parentProjectId: Int = 0,
    val isFavorite: Boolean = false,
    val color: ProjectColor = ProjectColor.RED,
    val status: ProjectStatus = ProjectStatus.ACTIVE
)