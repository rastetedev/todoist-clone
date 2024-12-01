package com.raulastete.todoistclone.settings.quickadd

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.quickAddNavigation(
    navController: NavHostController
) {
    composable<Route.Configuration.QuickAdd> {
        QuickAddScreen(
            quickAddViewModel = viewModel(),
            onNavigateBack = navController::popBackStack
        )
    }
}