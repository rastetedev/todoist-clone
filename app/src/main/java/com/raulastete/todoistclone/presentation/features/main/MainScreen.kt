package com.raulastete.todoistclone.presentation.features.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.raulastete.todoistclone.presentation.features.browse.BrowseDestination
import com.raulastete.todoistclone.presentation.core.models.BottomItemModel
import com.raulastete.todoistclone.presentation.core.models.toModel
import com.raulastete.todoistclone.domain.entity.BottomItem
import com.raulastete.todoistclone.presentation.features.filtersNLabels.FiltersNLabelsDestination
import com.raulastete.todoistclone.presentation.features.inbox.InboxDestination
import com.raulastete.todoistclone.presentation.features.notifications.NotificationsNavigation
import com.raulastete.todoistclone.presentation.features.search.SearchDestination
import com.raulastete.todoistclone.presentation.features.today.TodayNavigation
import com.raulastete.todoistclone.presentation.features.upcoming.UpcomingNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavController: NavHostController,
    bottomItemModelList: List<BottomItemModel> = BottomItem.entries.toList().map { it.toModel() },
    onNavigateToNotifications: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    val bottomItemSelected = currentDestination?.toBottomItem()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    bottomItemSelected?.ScreenTitle()
                },
                actions = {
                    bottomItemSelected?.TopBarActions(
                        onNavigateToNotifications = onNavigateToNotifications,
                        onNavigateToSettings = onNavigateToSettings,
                        onShowMenu = {
                            //TODO: Implement show menu
                        }
                    )
                }
            )
        },
        bottomBar = {
            MyBottomBar(
                currentDestination = currentDestination,
                bottomNavController = bottomNavController,
                bottomItemModelList = bottomItemModelList,
            )
        }
    ) { padding ->

        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            navController = bottomNavController,
            startDestination = bottomItemModelList.first().route
        ) {
            TodayNavigation(navController = rootNavController)
            UpcomingNavigation(navController = rootNavController)
            FiltersNLabelsDestination(navController = rootNavController)
            NotificationsNavigation(navController = rootNavController)
            InboxDestination(navController = rootNavController)
            SearchDestination(navController = rootNavController)
            BrowseDestination(navController = rootNavController)
        }
    }
}

@Composable
fun MyBottomBar(
    currentDestination: String?,
    bottomNavController: NavHostController,
    bottomItemModelList: List<BottomItemModel>
) {
    NavigationBar {
        bottomItemModelList
            .filter { it.visible }
            .sortedBy { it.position }
            .take(5) //MAX 5 ITEMS IN BOTTOM BAR
            .forEach { bottomItemModel ->
                NavigationBarItem(
                    selected = currentDestination?.contains(bottomItemModel.route.toString())
                        ?: false,
                    onClick = {
                        bottomNavController.navigate(bottomItemModel.route) {
                            popUpTo(bottomNavController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(bottomItemModel.icon, contentDescription = null) },
                    label = { Text(stringResource(bottomItemModel.label)) }
                )
            }
    }
}

private fun String.toBottomItem(): BottomItem? {
    return BottomItem.entries.firstOrNull { bottomItem ->
        this == bottomItem.toModel().route.toString()
    }
}