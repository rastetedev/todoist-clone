package com.raulastete.todoistclone.projects.management

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.entity.ProjectStatus

@Composable
fun ProjectManagementScreen(
    projectManagementViewModel: ProjectManagementViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit
) {
    val projectManagementUiState by projectManagementViewModel.uiState.collectAsStateWithLifecycle()

    ProjectManagementContent(
        projectManagementUiState = projectManagementUiState,
        onNavigateBack = onNavigateBack,
        onNavigateToCreateProject = onNavigateToCreateProject,
        onNavigateToProject = onNavigateToProject,
        sendIntent = projectManagementViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectManagementContent(
    projectManagementUiState: ProjectManagementUiState,
    onNavigateBack: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit,
    sendIntent: (ProjectManagementIntent) -> Unit
) {
    with(projectManagementUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(stringResource(R.string.project_management_screen_title))
                    },
                    actions = {
                        IconButton(onClick = onNavigateToCreateProject) {
                            Icon(Icons.Default.Add, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DockedSearchBar(
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = projectSearchQuery,
                            onQueryChange = { query ->
                                sendIntent(ProjectManagementIntent.SearchQueryChange(query))
                            },
                            onSearch = {
                                sendIntent(ProjectManagementIntent.Search)
                            },
                            expanded = false,
                            onExpandedChange = {},
                            placeholder = {
                                Text(stringResource(R.string.search_projects_placeholder))
                            },
                            leadingIcon = {
                                Icon(Icons.Default.Search, contentDescription = null)
                            }
                        )
                    },
                    expanded = false,
                    onExpandedChange = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    shape = SearchBarDefaults.dockedShape,
                    colors = SearchBarDefaults.colors(),
                    tonalElevation = SearchBarDefaults.TonalElevation,
                    shadowElevation = SearchBarDefaults.ShadowElevation,
                    content = {}
                )

                ElevatedAssistChip(
                    onClick = { sendIntent(ProjectManagementIntent.ToggleProjectStatusOptions) },
                    modifier = Modifier.padding(start = 16.dp),
                    trailingIcon = {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            stringResource(
                                if (projectStatus == ProjectStatus.ACTIVE) R.string.active_projects
                                else R.string.archived_projects
                            )
                        )
                    }
                )

                Text(
                    text = pluralStringResource(
                        R.plurals.projects_quantity,
                        projectList.size,
                        projectList.size
                    ),
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )

                LazyColumn {
                    items(projectList, key = { project -> project.id }) {
                        ListItem(
                            modifier = Modifier.clickable {
                                onNavigateToProject(it.id)
                            },
                            leadingContent = {
                                Icon(Icons.Default.Numbers, contentDescription = null)
                            },
                            headlineContent = {
                                Text(it.name)
                            }
                        )
                    }
                }
            }

            if (showProjectFilterOptions) {
                ModalBottomSheet(
                    onDismissRequest = {
                        sendIntent(ProjectManagementIntent.ToggleProjectStatusOptions)
                    }) {
                    Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                        Text(
                            stringResource(R.string.project_status_options),
                            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = projectStatus == ProjectStatus.ACTIVE,
                                onClick = {
                                    sendIntent(
                                        ProjectManagementIntent.ChangeProjectStatusFilter(
                                            ProjectStatus.ACTIVE
                                        )
                                    )
                                }
                            )
                            Text(stringResource(R.string.active_projects))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = projectStatus == ProjectStatus.ARCHIVED,
                                onClick = {
                                    sendIntent(
                                        ProjectManagementIntent.ChangeProjectStatusFilter(
                                            ProjectStatus.ARCHIVED
                                        )
                                    )
                                }
                            )
                            Text(stringResource(R.string.archived_projects))
                        }
                    }
                }
            }
        }
    }
}