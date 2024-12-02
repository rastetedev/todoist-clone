package com.raulastete.todoistclone.presentation.features.projects.management

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.projectManagementDestination(
    navController: NavHostController
) {
    composable<Route.ManageProjects> {
        ProjectManagementScreen(
            projectManagementViewModel = koinViewModel(),
            onNavigateBack = navController::popBackStack,
            onNavigateToCreateProject = {
                navController.navigate(Route.CreateProject)
            },
            onNavigateToProject = {
                navController.navigate(Route.Project(it))
            }
        )
    }
}