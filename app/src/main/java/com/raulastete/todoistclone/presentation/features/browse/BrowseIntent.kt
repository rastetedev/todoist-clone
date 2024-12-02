package com.raulastete.todoistclone.presentation.features.browse

sealed interface BrowseIntent {
    data object ToggleProjectVisibility : BrowseIntent
}