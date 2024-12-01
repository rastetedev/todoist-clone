package com.raulastete.todoistclone.settings.quickadd

import com.raulastete.todoistclone.domain.entity.QuickAddAction

sealed interface QuickAddIntent {

    data object ToggleShowActionLabelsOption : QuickAddIntent
    data object AddAllTaskActionsToArrangement : QuickAddIntent
    data object RemoveAllTaskActionsFromArrangement : QuickAddIntent
    data class RemoveTaskActionFromArrangement(val quickAddAction: QuickAddAction) :
        QuickAddIntent

    data class AddTaskActionToArrangement(val quickAddAction: QuickAddAction) :
        QuickAddIntent
}