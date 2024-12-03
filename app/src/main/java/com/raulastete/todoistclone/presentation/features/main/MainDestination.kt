package com.raulastete.todoistclone.presentation.features.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.mainDestination(
    navController: NavHostController
){
    composable<Route.Main> {
        val bottomNavController = rememberNavController()

        MainScreen(
            rootNavController = navController,
            bottomNavController = bottomNavController,
            onNavigateToNotifications = {
                bottomNavController.navigate(Route.Notifications)
            },
            onNavigateToSettings = {
                navController.navigate(Route.Settings)
            },
        )
    }
}