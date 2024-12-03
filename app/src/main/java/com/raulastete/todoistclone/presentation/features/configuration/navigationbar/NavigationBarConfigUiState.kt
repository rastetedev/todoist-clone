package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement
import com.raulastete.todoistclone.presentation.core.models.BottomItemModel

data class NavigationBarConfigUiState(
    val dynamicAddButtonPlacementChecked: DynamicAddButtonPlacement = DynamicAddButtonPlacement.RIGHT,
    val bottomItemsArranged : List<BottomItemModel> = emptyList(),
    val bottomItemsHidden: List<BottomItemModel> = emptyList()
)