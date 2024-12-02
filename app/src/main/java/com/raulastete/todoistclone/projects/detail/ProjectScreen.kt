package com.raulastete.todoistclone.projects.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ProjectScreen(
    projectViewModel: ProjectViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToShareProject: (projectId: Long) -> Unit
) {
    val projectUiState by projectViewModel.uiState.collectAsStateWithLifecycle()

    ProjectContent(
        projectUiState = projectUiState,
        onNavigateBack = onNavigateBack,
        onNavigateToShareProject = onNavigateToShareProject
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectContent(
    projectUiState: ProjectUiState,
    onNavigateBack: () -> Unit,
    onNavigateToShareProject: (projectId: Long) -> Unit,
) {
    with(projectUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(text = projectUiState.projectName)
                    },
                    actions = {
                        IconButton(onClick = { onNavigateToShareProject(projectUiState.projectId) }) {
                            Icon(Icons.Default.PersonAddAlt1, contentDescription = null)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.MoreVert, contentDescription = null)
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)) {

            }
        }
    }
}
