package com.raulastete.todoistclone.presentation.features.settings.quickadd

import com.raulastete.todoistclone.domain.entity.QuickAddAction

data class QuickAddConfigUiState(
    val showActionLabels: Boolean = true,
    val taskActionsArrangement: List<QuickAddActionModel> = QuickAddAction.entries.filter { it.isPro.not() }.map { it.toModel() },
    val moreTaskActions: List<QuickAddActionModel> = QuickAddAction.entries.filter { it.isPro }.map { it.toModel() },
) {
    val isFullFilled: Boolean
        get() = taskActionsArrangement.size == QuickAddAction.entries.size
}