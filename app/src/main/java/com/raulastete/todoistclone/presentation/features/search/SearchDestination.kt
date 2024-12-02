package com.raulastete.todoistclone.presentation.features.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.raulastete.todoistclone.presentation.navigation.Route

fun NavGraphBuilder.SearchDestination(
    navController: NavController
) {
    composable<Route.Search> {
        SearchScreen()
    }
}