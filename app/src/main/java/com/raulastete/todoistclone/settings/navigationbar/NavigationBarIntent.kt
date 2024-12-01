package com.raulastete.todoistclone.settings.navigationbar

import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement

sealed interface NavigationBarIntent {

    data class ChangeDynamicAddButtonPlacement(
        val dynamicAddButtonPlacement: DynamicAddButtonPlacement,
        val isChecked: Boolean
    ) : NavigationBarIntent
}