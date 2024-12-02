package com.raulastete.todoistclone.data.repository

import com.raulastete.todoistclone.data.local.database.dao.ProjectDao
import com.raulastete.todoistclone.data.local.database.table.toProject
import com.raulastete.todoistclone.data.local.database.table.toProjectTable
import com.raulastete.todoistclone.domain.entity.Project
import com.raulastete.todoistclone.domain.repository.ProjectRepository

class DefaultProjectRepository(
    private val projectDao: ProjectDao
) : ProjectRepository {

    override suspend fun createProject(project: Project) : Long {
        return projectDao.createProject(project.toProjectTable())
    }

    override suspend fun getProject(projectId: Long): Project {
        return projectDao.getProjectSnapshot(projectId).toProject()
    }
}