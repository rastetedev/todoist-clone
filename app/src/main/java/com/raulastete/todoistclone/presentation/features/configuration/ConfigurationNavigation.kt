package com.raulastete.todoistclone.presentation.features.configuration

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raulastete.todoistclone.presentation.features.configuration.settings.settingsDestination
import com.raulastete.todoistclone.presentation.features.configuration.navigationbar.navigationBarConfigDestination
import com.raulastete.todoistclone.presentation.features.configuration.quickadd.quickAddConfigDestination
import com.raulastete.todoistclone.presentation.navigation.Route
import com.raulastete.todoistclone.presentation.navigation.Subgraph

fun NavGraphBuilder.configurationNavigation(
    navController: NavHostController
){
    navigation<Subgraph.Configuration>(startDestination = Route.Settings){

        settingsDestination(navController)

        composable<Route.Upgrade> { }

        composable<Route.AccountConfig> { }

        composable<Route.GeneralConfig> { }

        composable<Route.ThemeConfig> { }

        composable<Route.AppIconConfig> { }

        navigationBarConfigDestination(navController = navController)

        quickAddConfigDestination(navController = navController)

        composable<Route.RemindersConfig> { }

        composable<Route.NotificationsConfig> { }

        composable<Route.ProductivityConfig> { }
    }
}