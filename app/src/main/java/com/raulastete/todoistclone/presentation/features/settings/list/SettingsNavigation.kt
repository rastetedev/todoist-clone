package com.raulastete.todoistclone.presentation.features.settings.list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raulastete.todoistclone.presentation.features.settings.navigationbar.navigationBarConfigDestination
import com.raulastete.todoistclone.presentation.features.settings.quickadd.quickAddConfigDestination
import com.raulastete.todoistclone.presentation.navigation.Route
import com.raulastete.todoistclone.presentation.navigation.Subgraph

fun NavGraphBuilder.settingsNavigation(
    navController: NavHostController
){
    navigation<Subgraph.Configuration>(startDestination = Route.Settings){
        composable< Route.Settings> {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToAccountSettings = { navController.navigate(Route.AccountConfig) },
                onNavigateToGeneralSettings = { navController.navigate(Route.GeneralConfig) },
                onNavigateToThemeSettings = { navController.navigate(Route.ThemeConfig) },
                onNavigateToAppIconSettings = { navController.navigate(Route.AppIconConfig) },
                onNavigateToNavigationBarSettings = { navController.navigate(Route.NavigationBarConfig) },
                onNavigateToQuickAddSettings = { navController.navigate(Route.QuickAddConfig) },
                onNavigateToProductivitySettings = { navController.navigate(Route.Productivity) },
                onNavigateToRemindersSettings = { navController.navigate(Route.RemindersConfig) },
                onNavigateToNotificationsSettings = { navController.navigate(Route.Notifications) },
            )
        }

        composable<Route.Upgrade> { }

        composable<Route.AccountConfig> { }

        composable<Route.GeneralConfig> { }

        composable<Route.ThemeConfig> { }

        composable<Route.AppIconConfig> { }

        navigationBarConfigDestination(navController = navController)

        quickAddConfigDestination(navController = navController)

        composable<Route.Productivity> { }

        composable<Route.RemindersConfig> { }

        composable<Route.Notifications> { }

        composable<Route.Productivity> { }

        composable<Route.ActivityLog> { }
    }
}
