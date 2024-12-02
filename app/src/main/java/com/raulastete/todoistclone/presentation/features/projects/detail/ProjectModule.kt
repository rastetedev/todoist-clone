package com.raulastete.todoistclone.presentation.features.projects.detail

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