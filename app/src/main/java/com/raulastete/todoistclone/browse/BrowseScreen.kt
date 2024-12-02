package com.raulastete.todoistclone.browse

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.browse.components.UsernameHeader

@Composable
fun BrowseScreen(
    browseViewModel: BrowseViewModel,
    onNavigateToProductivity: () -> Unit,
    onNavigateToNotifications: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToInbox: () -> Unit,
    onNavigateToActivityLog: () -> Unit,
    onNavigateToFiltersNTags: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit,
    onNavigateToManageProjects: () -> Unit
) {
    val browseUiState by browseViewModel.uiState.collectAsStateWithLifecycle()

    BrowseContent(
        browseUiState = browseUiState,
        onNavigateToProductivity = onNavigateToProductivity,
        onNavigateToNotifications = onNavigateToNotifications,
        onNavigateToSettings = onNavigateToSettings,
        onNavigateToInbox = onNavigateToInbox,
        onNavigateToActivityLog = onNavigateToActivityLog,
        onNavigateToFiltersNTags = onNavigateToFiltersNTags,
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
    onNavigateToProductivity: () -> Unit,
    onNavigateToNotifications: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToInbox: () -> Unit,
    onNavigateToActivityLog: () -> Unit,
    onNavigateToFiltersNTags: () -> Unit,
    onNavigateToCreateProject: () -> Unit,
    onNavigateToProject: (projectId: Long) -> Unit,
    onNavigateToManageProjects: () -> Unit,
    sendIntent: (BrowseIntent) -> Unit
) {
    with(browseUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { UsernameHeader(username = username) },
                    modifier = Modifier.clickable { onNavigateToProductivity() },
                    actions = {
                        IconButton(onClick = onNavigateToNotifications) {
                            Icon(Icons.Default.Notifications, contentDescription = null)
                        }
                        IconButton(onClick = onNavigateToSettings) {
                            Icon(Icons.Default.Settings, contentDescription = null)
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
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
                    modifier = Modifier.clickable { onNavigateToFiltersNTags() },
                    leadingContent = {
                        Icon(
                            Icons.Default.Filter,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    headlineContent = { Text(stringResource(R.string.filters_tags)) }
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
}