package com.raulastete.todoistclone.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.raulastete.todoistclone.data.local.database.table.ProjectTable

@Dao
interface ProjectDao {

    @Insert
    suspend fun createProject(project: ProjectTable) : Long

    @Query("SELECT * FROM ProjectTable WHERE id = :projectId")
    suspend fun getProjectSnapshot(projectId: Long) : ProjectTable
}