package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.navigationBarConfigDestination(
    navController: NavHostController
) {

    composable<Route.NavigationBarConfig> {
        NavigationBarConfigScreen(
            navigationBarConfigViewModel = viewModel(),
            onNavigateBack = { navController.popBackStack() },
        )
    }
}