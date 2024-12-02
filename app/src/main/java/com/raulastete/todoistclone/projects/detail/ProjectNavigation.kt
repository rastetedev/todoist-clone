package com.raulastete.todoistclone.projects.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route
import org.koin.androidx.compose.koinViewModel

const val PROJECT_ID_KEY = "projectId"

fun NavGraphBuilder.projectNavigation(
    navController: NavHostController
) {

    composable<Route.Main.Project> {

        val projectViewModel = koinViewModel<ProjectViewModel>()

        ProjectScreen(
            projectViewModel = projectViewModel,
            onNavigateBack = { navController.popBackStack<Route.Main.Browse>(inclusive = true) },
            onNavigateToShareProject = { }
        )
    }
}