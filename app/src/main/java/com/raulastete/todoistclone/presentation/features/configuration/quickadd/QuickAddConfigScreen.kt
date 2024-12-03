package com.raulastete.todoistclone.presentation.features.configuration.quickadd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.presentation.components.DefaultQuickAddAction
import com.raulastete.todoistclone.presentation.components.ProBadge
import com.raulastete.todoistclone.presentation.components.QuickAddActionChip
import com.raulastete.todoistclone.presentation.components.SectionTitle

@Composable
fun QuickAddConfigScreen(
    quickAddConfigViewModel: QuickAddConfigViewModel,
    onNavigateBack: () -> Unit
) {
    val quickAddUiState by quickAddConfigViewModel.uiState.collectAsStateWithLifecycle()

    QuickAddContent(
        quickAddConfigUiState = quickAddUiState,
        onNavigateBack = onNavigateBack,
        sendIntent = quickAddConfigViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickAddContent(
    quickAddConfigUiState: QuickAddConfigUiState,
    onNavigateBack: () -> Unit,
    sendIntent: (QuickAddConfigIntent) -> Unit
) {
    with(quickAddConfigUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = { Text(stringResource(R.string.quick_add_screen_title)) }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                ShowActionLabelsSection(
                    isChecked = showActionLabels,
                    onCheckedChange = { sendIntent(QuickAddConfigIntent.ToggleShowActionLabelsOption) }
                )

                Spacer(Modifier.height(16.dp))

                PreviewSection(taskActionsArrangement)

                Spacer(Modifier.height(32.dp))

                HorizontalDivider()

                TaskActionsArrangementSection(
                    isFullFilled = isFullFilled,
                    quickAddActions = taskActionsArrangement,
                    sendIntent = sendIntent
                )
                Spacer(Modifier.height(16.dp))

                if (isFullFilled.not()) {
                    MoreTaskActionsSection(
                        quickAddActions = moreTaskActions,
                        sendIntent = sendIntent
                    )
                }
            }
        }
    }
}

@Composable
private fun ShowActionLabelsSection(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(stringResource(R.string.show_action_labels_title), fontWeight = FontWeight.Medium)
            Text(
                stringResource(
                    if (isChecked) R.string.show_action_labels_description_visible
                    else R.string.show_action_labels_description_hidden
                ),
                fontSize = 12.sp
            )
        }
        Switch(checked = isChecked, onCheckedChange = onCheckedChange)
    }
}

@Composable
private fun PreviewSection(taskActionsArrangement: List<QuickAddActionModel>) {
    Column {
        SectionTitle(text = stringResource(R.string.preview))
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(taskActionsArrangement) { action ->
                QuickAddActionChip(action)
            }
            item {
                DefaultQuickAddAction()
            }
        }
    }
}

@Composable
private fun TaskActionsArrangementSection(
    isFullFilled: Boolean,
    quickAddActions: List<QuickAddActionModel>,
    sendIntent: (QuickAddConfigIntent) -> Unit
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SectionTitle(text = stringResource(R.string.task_actions_arrangement_title))

            Spacer(Modifier.weight(1f))
            if (isFullFilled) {
                TextButton(onClick = {
                    sendIntent(QuickAddConfigIntent.RemoveAllTaskActionsFromArrangement)
                }) {
                    Text(stringResource(R.string.hide_all_button))
                }
            } else {
                TextButton(onClick = {
                    sendIntent(QuickAddConfigIntent.AddConfigAllTaskActionsToArrangement)
                }) {
                    Text(stringResource(R.string.show_all_button))
                }
            }
        }

        quickAddActions.forEach { quickAddActionModel ->
            TaskActionItem(
                isHidden = false, quickAddActionModel = quickAddActionModel,
                sendIntent = sendIntent
            )
        }
    }
}

@Composable
private fun MoreTaskActionsSection(
    quickAddActions: List<QuickAddActionModel>,
    sendIntent: (QuickAddConfigIntent) -> Unit
) {
    Column {
        SectionTitle(text = stringResource(R.string.more_task_actions_title))
        Spacer(Modifier.height(8.dp))
        quickAddActions.forEach { quickAddActionModel ->
            TaskActionItem(
                isHidden = true,
                quickAddActionModel = quickAddActionModel,
                sendIntent = sendIntent
            )
        }
    }
}


@Composable
private fun TaskActionItem(
    isHidden: Boolean,
    quickAddActionModel: QuickAddActionModel,
    sendIntent: (QuickAddConfigIntent) -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isHidden) {
            IconButton(onClick = {
                sendIntent(QuickAddConfigIntent.AddConfigTaskActionToArrangement(quickAddActionModel.key))
            }) {
                Icon(
                    Icons.Default.AddCircle, contentDescription = null,
                    tint = Color.Blue.copy(alpha = 0.7f)
                )
            }
        } else {
            IconButton(onClick = {
                sendIntent(QuickAddConfigIntent.RemoveTaskActionFromArrangement(quickAddActionModel.key))
            }) {
                Icon(
                    Icons.Default.RemoveCircle,
                    contentDescription = null,
                    tint = Color.Red.copy(alpha = 0.7f)
                )
            }
        }

        Icon(quickAddActionModel.icon, contentDescription = null)
        Text(stringResource(quickAddActionModel.name))
        Spacer(Modifier.weight(1f))
        if (quickAddActionModel.isPro) {
            ProBadge()
        }
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = Icons.Default.Reorder,
            contentDescription = null
        )
    }
}