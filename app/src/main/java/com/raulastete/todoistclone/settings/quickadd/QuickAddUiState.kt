package com.raulastete.todoistclone.settings.quickadd

import com.raulastete.todoistclone.domain.entity.QuickAddAction

data class QuickAddUiState(
    val showActionLabels: Boolean = true,
    val taskActionsArrangement: List<QuickAddActionModel> = QuickAddAction.entries.filter { it.isPro.not() }.map { it.toModel() },
    val moreTaskActions: List<QuickAddActionModel> = QuickAddAction.entries.filter { it.isPro }.map { it.toModel() },
) {
    val isFullFilled: Boolean
        get() = taskActionsArrangement.size == QuickAddAction.entries.size
}