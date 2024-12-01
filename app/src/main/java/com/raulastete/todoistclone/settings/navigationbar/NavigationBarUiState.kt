package com.raulastete.todoistclone.settings.navigationbar

import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement

data class NavigationBarUiState(
    val dynamicAddButtonPlacementChecked: DynamicAddButtonPlacement = DynamicAddButtonPlacement.RIGHT
)