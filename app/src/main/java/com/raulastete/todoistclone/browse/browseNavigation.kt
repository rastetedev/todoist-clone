package com.raulastete.todoistclone.browse

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.browseNavigation(
    navController: NavHostController
) {

    composable<Route.Main.Browse> {
        BrowseScreen(
            browseViewModel = viewModel(),
            onNavigateToProductivity = { navController.navigate(Route.Main.Productivity) },
            onNavigateToNotifications = { navController.navigate(Route.Main.Notifications) },
            onNavigateToSettings = { navController.navigate(Route.Configuration.Settings) },
            onNavigateToInbox = { navController.navigate(Route.Main.Inbox) },
            onNavigateToActivityLog = { navController.navigate(Route.Main.ActivityLog) },
            onNavigateToFiltersNTags = { navController.navigate(Route.Main.FiltersNTags) },
            onNavigateToCreateProject = { navController.navigate(Route.Main.CreateProject) },
            onNavigateToProject = { projectId -> navController.navigate(Route.Main.Project(projectId)) },
            onNavigateToManageProjects = { navController.navigate(Route.Main.ManageProjects) }
        )
    }
}