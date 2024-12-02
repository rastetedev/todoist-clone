package com.raulastete.todoistclone.presentation.features.projects.management

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val projectManagementModule = module {
    viewModel {
        ProjectManagementViewModel(
            projectRepository = get()
        )
    }
}