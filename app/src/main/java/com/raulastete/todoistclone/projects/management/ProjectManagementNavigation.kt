package com.raulastete.todoistclone.projects.management

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.projectManagementNavigation(
    navController: NavHostController
) {
    composable<Route.Main.ManageProjects> {
        ProjectManagementScreen(
            projectManagementViewModel = koinViewModel(),
            onNavigateBack = navController::popBackStack,
            onNavigateToCreateProject = {
                navController.navigate(Route.Main.CreateProject)
            },
            onNavigateToProject = {
                navController.navigate(Route.Main.Project(it))
            }
        )
    }
}