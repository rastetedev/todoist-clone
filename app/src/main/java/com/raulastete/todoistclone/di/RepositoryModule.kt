package com.raulastete.todoistclone.di

import com.raulastete.todoistclone.data.repository.DefaultProjectRepository
import com.raulastete.todoistclone.domain.repository.ProjectRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProjectRepository> {
        DefaultProjectRepository(get())
    }
}