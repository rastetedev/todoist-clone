package com.raulastete.todoistclone.projects.creation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.projectCreationNavigation(
    navController: NavController
) {
    composable<Route.Main.CreateProject> {
        ProjectCreationScreen(
            projectCreationViewModel = viewModel(),
            onNavigateBack = { navController.popBackStack() },
        )
    }
}