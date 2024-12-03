package com.raulastete.todoistclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.raulastete.todoistclone.presentation.features.configuration.configurationNavigation
import com.raulastete.todoistclone.presentation.features.main.mainDestination
import com.raulastete.todoistclone.presentation.features.projects.creation.projectCreationDestination
import com.raulastete.todoistclone.presentation.features.projects.detail.projectDestination
import com.raulastete.todoistclone.presentation.features.projects.management.projectManagementDestination

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        navigation<Subgraph.Authentication>(startDestination = Route.Login) {
            composable<Route.Login> {
                //TODO: Not implemented yet
            }
        }

        mainDestination(navController = navController)

        configurationNavigation(navController = navController)

        projectCreationDestination(navController = navController)

        projectManagementDestination(navController = navController)

        projectDestination(navController = navController)
    }
}