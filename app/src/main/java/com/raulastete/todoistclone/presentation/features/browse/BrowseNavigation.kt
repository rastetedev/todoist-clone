package com.raulastete.todoistclone.presentation.features.browse

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.BrowseNavigation(
    navController: NavHostController
) {
    composable<Route.Browse> {
        BrowseScreen(
            browseViewModel = koinViewModel(),
            onNavigateToInbox = { navController.navigate(Route.Inbox) },
            onNavigateToActivityLog = { navController.navigate(Route.ActivityLog) },
            onNavigateToFiltersNLabels = { navController.navigate(Route.FiltersNLabels) },
            onNavigateToCreateProject = { navController.navigate(Route.CreateProject) },
            onNavigateToProject = { projectId -> navController.navigate(Route.Project(projectId)) },
            onNavigateToManageProjects = { navController.navigate(Route.ManageProjects) }
        )
    }
}