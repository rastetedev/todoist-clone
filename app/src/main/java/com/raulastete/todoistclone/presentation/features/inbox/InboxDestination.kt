package com.raulastete.todoistclone.presentation.features.inbox

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.InboxDestination(
    navController: NavController
) {
    composable<Route.Inbox> {
        InboxScreen()
    }
}