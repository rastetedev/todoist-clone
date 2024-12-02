package com.raulastete.todoistclone.presentation.features.projects.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route
import org.koin.androidx.compose.koinViewModel

const val PROJECT_ID_KEY = "projectId"

fun NavGraphBuilder.projectDestination(
    navController: NavHostController
) {

    composable<Route.Project> {

        val projectViewModel = koinViewModel<ProjectViewModel>()

        ProjectScreen(
            projectViewModel = projectViewModel,
            onNavigateBack = { navController.popBackStack(route = Route.Browse, inclusive = false) },
            onNavigateToShareProject = { }
        )
    }
}