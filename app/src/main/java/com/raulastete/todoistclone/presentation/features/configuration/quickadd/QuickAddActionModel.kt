package com.raulastete.todoistclone.presentation.features.configuration.quickadd

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.NewLabel
import androidx.compose.material.icons.filled.OutlinedFlag
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Today
import androidx.compose.ui.graphics.vector.ImageVector
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.entity.QuickAddAction

data class QuickAddActionModel(
    val key : QuickAddAction,
    @StringRes val name: Int,
    val icon: ImageVector,
    val isPro: Boolean = false,
    val isArranged: Boolean = true
)

fun QuickAddAction.toModel() : QuickAddActionModel {
   return when (this) {
        QuickAddAction.REMINDERS -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_reminders,
            icon = Icons.Default.Alarm
        )

        QuickAddAction.PRIORITY -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_priority,
            icon = Icons.Default.OutlinedFlag
        )

        QuickAddAction.DUE_DATE -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_due_date,
            icon = Icons.Default.Today
        )

        QuickAddAction.ASSIGNEE -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_asignee,
            icon = Icons.Default.PersonOutline
        )

        QuickAddAction.LABELS -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_labels,
            icon = Icons.Default.NewLabel,
        )

        QuickAddAction.LOCATION -> QuickAddActionModel(
            key = this,
            name = R.string.quick_action_location,
            icon = Icons.Default.MyLocation,
            isPro = this.isPro
        )
    }
}