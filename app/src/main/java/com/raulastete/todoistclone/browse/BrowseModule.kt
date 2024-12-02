package com.raulastete.todoistclone.browse

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val browseModule = module {
    viewModel {
        BrowseViewModel(
            projectRepository = get()
        )
    }
}