package com.raulastete.todoistclone.settings.navigationbar

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.navigation.Route

fun NavGraphBuilder.navigationBarNavigation(
    navController: NavHostController
) {

    composable<Route.Configuration.NavigationBar> {
        NavigationBarScreen(
            navigationBarViewModel = viewModel(),
            onNavigateBack = { navController.popBackStack() },
        )
    }
}