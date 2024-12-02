package com.raulastete.todoistclone.presentation.features.settings.quickadd

import androidx.lifecycle.ViewModel
import com.raulastete.todoistclone.domain.entity.QuickAddAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuickAddConfigViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuickAddConfigUiState())
    val uiState: StateFlow<QuickAddConfigUiState> = _uiState.asStateFlow()

    fun onIntent(intent: QuickAddConfigIntent) {
        when (intent) {
            QuickAddConfigIntent.ToggleShowActionLabelsOption -> {
                _uiState.update { it.copy(showActionLabels = !it.showActionLabels) }
            }

            QuickAddConfigIntent.AddConfigAllTaskActionsToArrangement -> {
                _uiState.update {
                    it.copy(
                        taskActionsArrangement = QuickAddAction.entries.toList()
                            .map { action -> action.toModel() },
                        moreTaskActions = emptyList()
                    )
                }
            }
            QuickAddConfigIntent.RemoveAllTaskActionsFromArrangement -> {
                _uiState.update {
                    it.copy(
                        moreTaskActions = QuickAddAction.entries.toList()
                            .map { action -> action.toModel() },
                        taskActionsArrangement = emptyList()
                    )
                }
            }
            is QuickAddConfigIntent.AddConfigTaskActionToArrangement -> {
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
            is QuickAddConfigIntent.RemoveTaskActionFromArrangement -> {
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