package com.raulastete.todoistclone.data.local.database.table

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.entity.ProjectColor

@Entity
data class ProjectTable(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val color: String,
    val parentId: Long,
    val isFavorite: Boolean
)

fun Project.toProjectTable(): ProjectTable =
    ProjectTable(
        id = id,
        name = name,
        parentId = parentProjectId,
        color = color.name,
        isFavorite = isFavorite
    )

fun ProjectTable.toProject(): Project =
    Project(
        id = id,
        name = name,
        parentProjectId = parentId,
        color = ProjectColor.valueOf(color),
        isFavorite = isFavorite
    )