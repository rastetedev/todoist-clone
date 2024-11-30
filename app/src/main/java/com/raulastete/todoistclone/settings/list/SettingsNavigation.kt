package com.raulastete.todoistclone.settings.list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.settingsNavigation(
    navController: NavHostController
){
    composable< Route.Configuration.Settings> {
        SettingsScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateToAccountSettings = { navController.navigate(Route.Configuration.Account) },
            onNavigateToGeneralSettings = { navController.navigate(Route.Configuration.General) },
            onNavigateToThemeSettings = { navController.navigate(Route.Configuration.Theme) },
            onNavigateToAppIconSettings = { navController.navigate(Route.Configuration.AppIcon) },
            onNavigateToNavigationBarSettings = { navController.navigate(Route.Configuration.NavigationBar) },
            onNavigateToQuickAddSettings = { navController.navigate(Route.Configuration.QuickAdd) },
            onNavigateToProductivitySettings = { navController.navigate(Route.Configuration.Productivity) },
            onNavigateToRemindersSettings = { navController.navigate(Route.Configuration.Reminders) },
            onNavigateToNotificationsSettings = { navController.navigate(Route.Configuration.Notifications) },
        )
    }
}
