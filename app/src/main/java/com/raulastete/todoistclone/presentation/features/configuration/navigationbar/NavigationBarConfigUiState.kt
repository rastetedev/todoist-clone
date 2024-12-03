package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement

data class NavigationBarConfigUiState(
    val dynamicAddButtonPlacementChecked: DynamicAddButtonPlacement = DynamicAddButtonPlacement.RIGHT
)