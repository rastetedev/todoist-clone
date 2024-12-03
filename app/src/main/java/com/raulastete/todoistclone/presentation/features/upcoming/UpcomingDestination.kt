package com.raulastete.todoistclone.presentation.features.upcoming

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.upcomingDestination(
    navController: NavController
) {
    composable<Route.Upcoming> {
        UpcomingScreen()
    }
}