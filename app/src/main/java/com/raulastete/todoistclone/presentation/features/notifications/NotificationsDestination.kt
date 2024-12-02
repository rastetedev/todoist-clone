package com.raulastete.todoistclone.presentation.features.notifications

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.NotificationsNavigation(
    navController: NavController
) {
    composable<Route.Notifications> {
        NotificationsScreen()
    }
}