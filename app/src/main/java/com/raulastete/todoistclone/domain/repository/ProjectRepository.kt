package com.raulastete.todoistclone.domain.repository

import com.raulastete.todoistclone.domain.entity.Project

interface ProjectRepository {

    suspend fun createProject(project: Project) : Long

    suspend fun getProject(projectId: Long) : Project
}