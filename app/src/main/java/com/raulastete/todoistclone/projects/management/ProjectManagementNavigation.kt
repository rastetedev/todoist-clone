package com.raulastete.todoistclone.projects.management

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.projectManagementNavigation(
    navController: NavHostController
) {
    composable<Route.Main.ManageProjects> {
        ProjectManagementScreen(
            projectManagementViewModel = viewModel(),
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