package com.raulastete.todoistclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.browse.browseNavigation
import com.raulastete.todoistclone.projects.creation.projectCreationNavigation
import com.raulastete.todoistclone.projects.detail.projectNavigation
import com.raulastete.todoistclone.projects.management.projectManagementNavigation
import com.raulastete.todoistclone.settings.list.settingsNavigation
import com.raulastete.todoistclone.settings.navigationbar.navigationBarNavigation
import com.raulastete.todoistclone.settings.quickadd.quickAddNavigation

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Route
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable<Route.Main.Today> { }

        composable<Route.Main.Upcoming> { }

        composable<Route.Main.Inbox> { }

        composable<Route.Main.Search> { }

        composable<Route.Main.Notifications> { }

        composable<Route.Main.FiltersNTags> { }

        browseNavigation(navController = navController)

        composable<Route.Main.Productivity> { }

        composable<Route.Main.ActivityLog> { }

        projectCreationNavigation(navController = navController)

        projectManagementNavigation(navController = navController)

        projectNavigation(navController = navController)

        settingsNavigation(navController = navController)

        composable<Route.Configuration.Upgrade> { }

        composable<Route.Configuration.Account> { }

        composable<Route.Configuration.General> { }

        composable<Route.Configuration.Theme> { }

        composable<Route.Configuration.AppIcon> { }

        navigationBarNavigation(navController = navController)

        quickAddNavigation(navController = navController)

        composable<Route.Configuration.Productivity> { }

        composable<Route.Configuration.Reminders> { }

        composable<Route.Configuration.Notifications> { }
    }
}