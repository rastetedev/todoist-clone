package com.raulastete.todoistclone.presentation.features.configuration.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.settingsDestination(
    navController: NavHostController
){
    composable< Route.Settings> {
        SettingsScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateToAccountSettings = { navController.navigate(Route.AccountConfig) },
            onNavigateToGeneralSettings = { navController.navigate(Route.GeneralConfig) },
            onNavigateToThemeSettings = { navController.navigate(Route.ThemeConfig) },
            onNavigateToAppIconSettings = { navController.navigate(Route.AppIconConfig) },
            onNavigateToNavigationBarSettings = { navController.navigate(Route.NavigationBarConfig) },
            onNavigateToQuickAddSettings = { navController.navigate(Route.QuickAddConfig) },
            onNavigateToProductivitySettings = { navController.navigate(Route.ProductivityConfig) },
            onNavigateToRemindersSettings = { navController.navigate(Route.RemindersConfig) },
            onNavigateToNotificationsSettings = { navController.navigate(Route.NotificationsConfig) },
        )
    }
}
