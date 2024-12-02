package com.raulastete.todoistclone.domain.entity

data class Project(
    val id: Long = 0L,
    val name: String,
    val parentProjectId: Long = 0L,
    val isFavorite: Boolean = false,
    val color: ProjectColor = ProjectColor.RED,
    val status: ProjectStatus = ProjectStatus.ACTIVE
)