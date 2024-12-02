package com.raulastete.todoistclone.projects.creation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.projectCreationNavigation(
    navController: NavController
) {
    composable<Route.Main.CreateProject> {
        ProjectCreationScreen(
            projectCreationViewModel = koinViewModel(),
            onNavigateBack = { navController.popBackStack() },
            onNavigateToProject = { navController.navigate(Route.Main.Project(it)) }
        )
    }
}