package com.raulastete.todoistclone.presentation.features.today

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.todayDestination(
    navController: NavController
) {
    composable<Route.Today> {
        TodayScreen()
    }
}