package com.raulastete.todoistclone.browse

sealed interface BrowseIntent {
    data object ToggleProjectVisibility : BrowseIntent
}