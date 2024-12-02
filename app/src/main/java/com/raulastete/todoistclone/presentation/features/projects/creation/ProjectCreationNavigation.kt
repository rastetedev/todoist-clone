package com.raulastete.todoistclone.presentation.features.projects.creation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.projectCreationDestination(
    navController: NavController
) {
    composable<Route.CreateProject> {
        ProjectCreationScreen(
            projectCreationViewModel = koinViewModel(),
            onNavigateBack = { navController.popBackStack() },
            onNavigateToProject = { navController.navigate(Route.Project(it)) }
        )
    }
}