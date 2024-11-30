package com.raulastete.todoistclone.settings.navigationbar

import com.raulastete.todoistclone.domain.DynamicAddButtonPlacement

data class NavigationBarUiState(
    val dynamicAddButtonPlacementChecked: DynamicAddButtonPlacement = DynamicAddButtonPlacement.RIGHT
)