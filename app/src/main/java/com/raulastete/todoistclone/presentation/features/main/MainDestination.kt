package com.raulastete.todoistclone.presentation.features.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.mainDestination(
    navController: NavHostController
){
    composable<Route.Main> {
        MainScreen(
            rootNavController = navController,
            onNavigateToNotifications = { },
            onNavigateToSettings = { },
        )
    }
}