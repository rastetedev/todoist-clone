package com.raulastete.todoistclone.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raulastete.todoistclone.data.local.database.dao.ProjectDao
import com.raulastete.todoistclone.data.local.database.table.ProjectTable

@Database(version = 1, entities = [ProjectTable::class])
abstract class TodoistCloneDB : RoomDatabase() {

    abstract fun projectDao(): ProjectDao
}