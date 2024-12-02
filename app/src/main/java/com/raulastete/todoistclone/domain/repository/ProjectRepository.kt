package com.raulastete.todoistclone.domain.repository

import com.raulastete.todoistclone.domain.entity.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {

    suspend fun createProject(project: Project) : Long

    suspend fun getProject(projectId: Long) : Project

    suspend fun observeProjects() : Flow<List<Project>>
}