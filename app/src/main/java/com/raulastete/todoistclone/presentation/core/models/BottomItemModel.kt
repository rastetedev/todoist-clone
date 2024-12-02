package com.raulastete.todoistclone.presentation.core.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Upcoming
import androidx.compose.ui.graphics.vector.ImageVector
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.entity.BottomItem
import com.raulastete.todoistclone.presentation.navigation.Route

data class BottomItemModel(
    val route: Route,
    @StringRes val label: Int,
    val icon: ImageVector,
    val visible: Boolean,
    val position: Short,
    val isPinned: Boolean = false
)

fun BottomItem.toModel(): BottomItemModel {
    return when (this) {
        BottomItem.TODAY -> BottomItemModel(
            route = Route.Today,
            label = R.string.today_nav_item,
            icon = Icons.Default.Today,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.FILTERS_N_LABELS -> BottomItemModel(
            route = Route.FiltersNLabels,
            label = R.string.filter_labels_nav_item,
            icon = Icons.Default.FilterAlt,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.INBOX -> BottomItemModel(
            route = Route.Inbox,
            label = R.string.inbox_nav_item,
            icon = Icons.Default.Inbox,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.NOTIFICATIONS -> BottomItemModel(
            route = Route.Notifications,
            label = R.string.notifications_nav_item,
            icon = Icons.Default.NotificationsNone,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.SEARCH -> BottomItemModel(
            route = Route.Search,
            label = R.string.search_nav_item,
            icon = Icons.Default.Search,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.BROWSE -> BottomItemModel(
            route = Route.Browse,
            label = R.string.browse_nav_item,
            icon = Icons.Default.Menu,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )

        BottomItem.UPCOMING -> BottomItemModel(
            route = Route.Upcoming,
            label = R.string.upcoming_nav_item,
            icon = Icons.Default.Upcoming,
            visible = visible,
            position = orderPosition.toShort(),
            isPinned = isPinned
        )
    }
}