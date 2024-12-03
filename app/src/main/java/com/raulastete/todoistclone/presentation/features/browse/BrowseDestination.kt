package com.raulastete.todoistclone.presentation.features.browse

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.browseDestination(
    rootNavController: NavHostController,
    bottomNavController: NavHostController
) {
    composable<Route.Browse> {
        BrowseScreen(
            browseViewModel = koinViewModel(),
            onNavigateToInbox = { bottomNavController.navigate(Route.Inbox) },
            onNavigateToActivityLog = { rootNavController.navigate(Route.ActivityLog) },
            onNavigateToFiltersNLabels = { bottomNavController.navigate(Route.FiltersNLabels) },
            onNavigateToCreateProject = { rootNavController.navigate(Route.CreateProject) },
            onNavigateToProject = { projectId -> rootNavController.navigate(Route.Project(projectId)) },
            onNavigateToManageProjects = { rootNavController.navigate(Route.ProjectManagement) }
        )
    }
}