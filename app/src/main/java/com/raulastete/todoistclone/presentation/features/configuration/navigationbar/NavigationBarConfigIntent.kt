package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement

sealed interface NavigationBarConfigIntent {

    data class ChangeDynamicAddButtonPlacement(
        val dynamicAddButtonPlacement: DynamicAddButtonPlacement,
        val isChecked: Boolean
    ) : NavigationBarConfigIntent
}