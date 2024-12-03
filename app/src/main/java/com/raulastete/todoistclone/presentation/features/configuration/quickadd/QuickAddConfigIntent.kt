package com.raulastete.todoistclone.presentation.features.configuration.quickadd

import com.raulastete.todoistclone.domain.entity.QuickAddAction

sealed interface QuickAddConfigIntent {

    data object ToggleShowActionLabelsOption : QuickAddConfigIntent
    data object AddConfigAllTaskActionsToArrangement : QuickAddConfigIntent
    data object RemoveAllTaskActionsFromArrangement : QuickAddConfigIntent
    data class RemoveTaskActionFromArrangement(val quickAddAction: QuickAddAction) :
        QuickAddConfigIntent

    data class AddConfigTaskActionToArrangement(val quickAddAction: QuickAddAction) :
        QuickAddConfigIntent
}