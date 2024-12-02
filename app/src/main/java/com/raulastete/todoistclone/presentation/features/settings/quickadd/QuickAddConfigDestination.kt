package com.raulastete.todoistclone.presentation.features.settings.quickadd

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.quickAddConfigDestination(
    navController: NavHostController
) {
    composable<Route.QuickAddConfig> {
        QuickAddConfigScreen(
            quickAddConfigViewModel = viewModel(),
            onNavigateBack = navController::popBackStack
        )
    }
}