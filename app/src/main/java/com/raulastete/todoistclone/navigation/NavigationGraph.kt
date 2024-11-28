package com.raulastete.todoistclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.browse.BrowseNavigation

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

        BrowseNavigation(navController = navController)

        composable<Route.Main.Productivity> { }

        composable<Route.Main.ActivityLog> { }

        composable<Route.Configuration.Settings> { }

        composable<Route.Configuration.Upgrade> { }

        composable<Route.Configuration.Account> { }

        composable<Route.Configuration.General> { }

        composable<Route.Configuration.Theme> { }

        composable<Route.Configuration.AppIcon> { }

        composable<Route.Configuration.NavigationMenu> { }

        composable<Route.Configuration.QuickAdd> { }

        composable<Route.Configuration.Productivity> { }

        composable<Route.Configuration.Reminders> { }

        composable<Route.Configuration.Notifications> { }
    }
}