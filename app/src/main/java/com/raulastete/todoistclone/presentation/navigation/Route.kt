package com.raulastete.todoistclone.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    data object Login : Route()

    @Serializable
    data object Main : Route()

    @Serializable
    data object Today : Route()

    @Serializable
    data object Upcoming : Route()

    @Serializable
    data object Inbox : Route()

    @Serializable
    data object Search : Route()

    @Serializable
    data object Notifications : Route()

    @Serializable
    data object FiltersNLabels : Route()

    @Serializable
    data object Browse : Route()

    @Serializable
    data object CreateProject : Route()

    @Serializable
    data object ProjectManagement : Route()

    @Serializable
    data class Project(val projectId: Long) : Route()

    @Serializable
    data object Productivity : Route() //Click to Username in Browse

    @Serializable
    data object ActivityLog : Route() //Click to Completed in Browse

    @Serializable
    data object Settings : Route()

    @Serializable
    data object Upgrade : Route()

    @Serializable
    data object AccountConfig : Route()

    @Serializable
    data object GeneralConfig : Route()

    @Serializable
    data object ThemeConfig : Route()

    @Serializable
    data object AppIconConfig : Route()

    @Serializable
    data object NavigationBarConfig : Route()

    @Serializable
    data object QuickAddConfig : Route()

    @Serializable
    data object ProductivityConfig : Route()

    @Serializable
    data object RemindersConfig : Route()

    @Serializable
    data object NotificationsConfig : Route()

}

sealed class Subgraph {

    @Serializable
    data object Authentication: Subgraph()

    @Serializable
    data object Configuration : Subgraph()

}