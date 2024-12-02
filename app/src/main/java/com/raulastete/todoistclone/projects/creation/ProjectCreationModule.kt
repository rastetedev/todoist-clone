package com.raulastete.todoistclone.projects.creation

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val projectCreationModule = module {
    viewModel {
        ProjectCreationViewModel(
            projectRepository = get()
        )
    }
}