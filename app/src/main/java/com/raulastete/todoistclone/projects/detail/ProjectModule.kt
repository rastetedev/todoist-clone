package com.raulastete.todoistclone.projects.detail

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val projectModule = module {
    viewModel {
        ProjectViewModel(
            projectRepository = get(),
            savedStateHandle = get()
        )
    }
}