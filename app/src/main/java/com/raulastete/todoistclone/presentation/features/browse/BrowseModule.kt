package com.raulastete.todoistclone.presentation.features.browse

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val browseModule = module {
    viewModel {
        BrowseViewModel(
            projectRepository = get()
        )
    }
}