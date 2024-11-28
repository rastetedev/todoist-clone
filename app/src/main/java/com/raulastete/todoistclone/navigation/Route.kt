package com.raulastete.todoistclone.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    sealed interface Main {
        @Serializable
        data object Today : Route

        @Serializable
        data object Upcoming : Route

        @Serializable
        data object Inbox : Route

        @Serializable
        data object Search : Route

        @Serializable
        data object Notifications : Route

        @Serializable
        data object FiltersNTags : Route

        @Serializable
        data object Browse : Route

        @Serializable
        data object Productivity : Route //Click to Username in Browse

        @Serializable
        data object ActivityLog : Route //Click to Completed in Browse

        @Serializable
        data object CreateProject : Route

        @Serializable
        data object ManageProjects : Route

        @Serializable
        data class Project(val projectId: Int) : Route
    }

    sealed interface Configuration {
        @Serializable
        data object Settings : Route

        @Serializable
        data object Upgrade : Route

        @Serializable
        data object Account : Route

        @Serializable
        data object General : Route

        @Serializable
        data object Theme : Route

        @Serializable
        data object AppIcon : Route

        @Serializable
        data object NavigationMenu : Route

        @Serializable
        data object QuickAdd : Route

        @Serializable
        data object Productivity : Route

        @Serializable
        data object Reminders : Route

        @Serializable
        data object Notifications : Route
    }
}