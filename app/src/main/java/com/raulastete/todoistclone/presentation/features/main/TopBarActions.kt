package com.raulastete.todoistclone.presentation.features.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.raulastete.todoistclone.domain.entity.BottomItem

@Composable
fun BottomItem.TopBarActions(
    onShowMenu: (BottomItem) -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToNotifications: () -> Unit,
) =
    when (this) {
        BottomItem.TODAY,
        BottomItem.UPCOMING,
        BottomItem.FILTERS_N_LABELS,
        BottomItem.SEARCH,
        BottomItem.NOTIFICATIONS,
        BottomItem.INBOX -> {
            IconButton(onClick = { onShowMenu(this) }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
            }
        }

        BottomItem.BROWSE -> {
            IconButton(onClick = onNavigateToNotifications) {
                Icon(Icons.Default.Notifications, contentDescription = null)
            }
            IconButton(onClick = onNavigateToSettings) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
            }
        }
    }