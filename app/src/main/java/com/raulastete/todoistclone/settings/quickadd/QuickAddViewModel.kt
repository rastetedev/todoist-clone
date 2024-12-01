package com.raulastete.todoistclone.settings.quickadd

import androidx.lifecycle.ViewModel
import com.raulastete.todoistclone.domain.entity.QuickAddAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuickAddViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuickAddUiState())
    val uiState: StateFlow<QuickAddUiState> = _uiState.asStateFlow()

    fun onIntent(intent: QuickAddIntent) {
        when (intent) {
            QuickAddIntent.ToggleShowActionLabelsOption -> {
                _uiState.update { it.copy(showActionLabels = !it.showActionLabels) }
            }

            QuickAddIntent.AddAllTaskActionsToArrangement -> {
                _uiState.update {
                    it.copy(
                        taskActionsArrangement = QuickAddAction.entries.toList()
                            .map { action -> action.toModel() },
                        moreTaskActions = emptyList()
                    )
                }
            }
            QuickAddIntent.RemoveAllTaskActionsFromArrangement -> {
                _uiState.update {
                    it.copy(
                        moreTaskActions = QuickAddAction.entries.toList()
                            .map { action -> action.toModel() },
                        taskActionsArrangement = emptyList()
                    )
                }
            }
            is QuickAddIntent.AddTaskActionToArrangement -> {
                _uiState.update {
                    it.copy(
                        taskActionsArrangement = it.taskActionsArrangement +
                               intent.quickAddAction.toModel(),
                        moreTaskActions = it.moreTaskActions.filter { action ->
                            action.key != intent.quickAddAction
                        }
                    )
                }
            }
            is QuickAddIntent.RemoveTaskActionFromArrangement -> {
                _uiState.update {
                    it.copy(
                        moreTaskActions = it.moreTaskActions +
                                intent.quickAddAction.toModel(),
                        taskActionsArrangement = it.taskActionsArrangement.filter { action ->
                            action.key != intent.quickAddAction
                        }
                    )
                }
            }
        }
    }
}