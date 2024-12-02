package com.raulastete.todoistclone.presentation.features.browse

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R

@Composable
fun BrowseScreen(
    browseViewModel: BrowseViewModel,
    onNavigateToInbox: () -> Unit,
    onNavigateToActivityLog: () -> Unit,
    onNavigateToFiltersNLabels: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit,
    onNavigateToManageProjects: () -> Unit
) {
    val browseUiState by browseViewModel.uiState.collectAsStateWithLifecycle()

    BrowseContent(
        browseUiState = browseUiState,
        onNavigateToInbox = onNavigateToInbox,
        onNavigateToActivityLog = onNavigateToActivityLog,
        onNavigateToFiltersNLabels = onNavigateToFiltersNLabels,
        onNavigateToCreateProject = onNavigateToCreateProject,
        onNavigateToProject = onNavigateToProject,
        onNavigateToManageProjects = onNavigateToManageProjects,
        sendIntent = browseViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseContent(
    browseUiState: BrowseUiState,
    onNavigateToInbox: () -> Unit,
    onNavigateToActivityLog: () -> Unit,
    onNavigateToFiltersNLabels: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit,
    onNavigateToManageProjects: () -> Unit,
    sendIntent: (BrowseIntent) -> Unit
) {
    with(browseUiState) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            ListItem(
                modifier = Modifier.clickable { onNavigateToInbox() },
                leadingContent = {
                    Icon(
                        Icons.Default.Inbox,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                headlineContent = { Text(stringResource(R.string.inbox)) },
                trailingContent = { Text(inboxQuantity) }
            )
            ListItem(
                modifier = Modifier.clickable { onNavigateToActivityLog() },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                headlineContent = { Text(stringResource(R.string.completed)) }
            )
            ListItem(
                modifier = Modifier.clickable { onNavigateToFiltersNLabels() },
                leadingContent = {
                    Icon(
                        Icons.Default.Filter,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                headlineContent = { Text(stringResource(R.string.filters_n_labels)) }
            )

            ListItem(
                headlineContent = { Text(stringResource(R.string.my_projects)) },
                trailingContent = {
                    Row(verticalAlignment = CenterVertically) {
                        IconButton(onClick = onNavigateToCreateProject) {
                            Icon(Icons.Default.Add, contentDescription = null)
                        }

                        AnimatedContent(
                            targetState = showProjects
                        ) { isVisible ->
                            IconButton(onClick = {
                                sendIntent(BrowseIntent.ToggleProjectVisibility)
                            }) {
                                if (isVisible) {
                                    Icon(
                                        Icons.Default.KeyboardArrowUp,
                                        contentDescription = null
                                    )
                                } else {
                                    Icon(
                                        Icons.Default.KeyboardArrowDown,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                }
            )

            AnimatedVisibility(showProjects) {

                LazyColumn {
                    items(projectList, key = { project -> project.id }) {
                        ListItem(
                            modifier = Modifier.clickable { onNavigateToProject(it.id) },
                            leadingContent = {
                                Icon(Icons.Default.Numbers, contentDescription = null)
                            },
                            headlineContent = { Text(it.name) }
                        )
                    }

                    item {
                        ListItem(
                            modifier = Modifier.clickable { onNavigateToManageProjects() },
                            leadingContent = {
                                Icon(Icons.Default.Edit, contentDescription = null)
                            },
                            headlineContent = { Text(stringResource(R.string.manage_projects)) }
                        )
                    }
                }
            }
        }
    }
}