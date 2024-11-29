package com.raulastete.todoistclone.projects.creation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AlignHorizontalLeft
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R

@Composable
fun ProjectCreationScreen(
    projectCreationViewModel: ProjectCreationViewModel,
    onNavigateBack: () -> Unit
) {
    val projectCreationUiState by projectCreationViewModel.uiState.collectAsStateWithLifecycle()

    ProjectCreationContent(
        projectCreationUiState = projectCreationUiState,
        onNavigateBack = onNavigateBack,
        sendIntent = projectCreationViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCreationContent(
    projectCreationUiState: ProjectCreationUiState,
    onNavigateBack: () -> Unit,
    sendIntent: (ProjectCreationIntent) -> Unit
) {
    with(projectCreationUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = { Text(stringResource(R.string.create_project_title)) },
                    actions = {
                        IconButton(onClick = { sendIntent(ProjectCreationIntent.CreateProject) }) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    value = projectName,
                    onValueChange = { value ->
                        sendIntent(
                            ProjectCreationIntent.ProjectNameChange(
                                value
                            )
                        )
                    },
                    label = {
                        Text(stringResource(R.string.project_name_label))
                    }
                )

                ListItem(
                    modifier = Modifier.clickable { sendIntent(ProjectCreationIntent.ToggleColorOptions) },
                    headlineContent = {
                        Text(stringResource(R.string.project_color_label))
                    },
                    leadingContent = {
                        Icon(Icons.AutoMirrored.Filled.List, contentDescription = null)
                    },
                    supportingContent = {
                        Text(projectColor.toPrintedName())
                    })


                ListItem(
                    modifier = Modifier.clickable { sendIntent(ProjectCreationIntent.ToggleProjectList) },
                    headlineContent = {
                        Text(stringResource(R.string.project_parent_label))
                    },
                    leadingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.AlignHorizontalLeft,
                            contentDescription = null
                        )
                    },
                    supportingContent = {
                        parentProject?.name?.ifBlank { stringResource(R.string.no_parent_project) }
                            ?.let { it1 -> Text(it1) }
                    }
                )

                ListItem(
                    modifier = Modifier.clickable { sendIntent(ProjectCreationIntent.ToggleFavoriteOption) },
                    headlineContent = {
                        Text(stringResource(R.string.project_favorite_label))
                    },
                    leadingContent = {
                        Icon(Icons.Default.StarOutline, contentDescription = null)
                    },
                    trailingContent = {
                        Switch(
                            checked = isFavoriteProject,
                            onCheckedChange = { sendIntent(ProjectCreationIntent.ToggleFavoriteOption) })
                    }
                )
            }

            if (showProjectColorOptions) {
                ModalBottomSheet(
                    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
                    onDismissRequest = { sendIntent(ProjectCreationIntent.ToggleColorOptions) }
                ) {
                    Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                        Text(
                            stringResource(R.string.project_color_label),
                            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                        )
                        Spacer(Modifier.height(8.dp))
                        LazyColumn {
                            items(colors) { projectColor ->
                                Row(
                                    modifier = Modifier
                                        .clickable {
                                            sendIntent(
                                                ProjectCreationIntent.ChangeProjectColor(
                                                    projectColor
                                                )
                                            )
                                        }
                                        .fillMaxWidth()
                                        .padding(top = 8.dp, bottom = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.List,
                                        contentDescription = null,
                                        tint = projectColor.drawColor()
                                    )
                                    Text(
                                        projectColor.toPrintedName()
                                    )
                                }
                            }
                        }
                    }
                }
            }

            if (showProjectParentOptions) {
                ModalBottomSheet(
                    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
                    onDismissRequest = { sendIntent(ProjectCreationIntent.ToggleProjectList) }
                ) {
                    Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                        Text(
                            stringResource(R.string.project_parent_label),
                            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                        )
                        Spacer(Modifier.height(8.dp))
                        LazyColumn {
                            items(projects) { parent ->
                                Row(
                                    modifier = Modifier
                                        .clickable {
                                            sendIntent(
                                                ProjectCreationIntent.ChangeParentProject(
                                                    parent
                                                )
                                            )
                                        }
                                        .fillMaxWidth()
                                        .padding(top = 8.dp, bottom = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Tag,
                                        contentDescription = null,
                                        tint = parent.color.drawColor()
                                    )
                                    Text(parent.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}