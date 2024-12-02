package com.raulastete.todoistclone.di

import androidx.room.Room
import com.raulastete.todoistclone.data.local.database.TodoistCloneDB
import com.raulastete.todoistclone.data.local.database.dao.ProjectDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<TodoistCloneDB> {
        Room.databaseBuilder(
            androidContext(),
            TodoistCloneDB::class.java,
            "todoist-clone-db"
        ).build()
    }

    single<ProjectDao>{
        get<TodoistCloneDB>().projectDao()
    }

}