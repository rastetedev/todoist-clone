package com.raulastete.todoistclone.settings.navigationbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Upcoming
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.DynamicAddButtonPlacement

@Composable
fun NavigationBarScreen(
    navigationBarViewModel: NavigationBarViewModel,
    onNavigateBack: () -> Unit
) {
    val navigationBarUiState by navigationBarViewModel.uiState.collectAsStateWithLifecycle()

    NavigationBarContent(
        navigationBarUiState = navigationBarUiState,
        onNavigateBack = onNavigateBack,
        sendIntent = navigationBarViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarContent(
    navigationBarUiState: NavigationBarUiState,
    onNavigateBack: () -> Unit,
    sendIntent: (NavigationBarIntent) -> Unit
) {
    with(navigationBarUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(stringResource(R.string.navigation_bar_title))
                    },
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Text(
                    stringResource(R.string.navigation_bar_headline),
                    style = MaterialTheme.typography.labelSmall
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    stringResource(R.string.dynamic_add_button_title),
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(32.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.LEFT,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.LEFT,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )
                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.CENTER,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.CENTER,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )
                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.RIGHT,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.RIGHT,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )
                }

                Spacer(Modifier.height(32.dp))

                HorizontalDivider()

                Text(stringResource(R.string.buttons_title))

                ButtonItem(
                    icon = Icons.Default.Today,
                    text = stringResource(R.string.today_nav_item)
                )

                ButtonItem(
                    icon = Icons.Default.Upcoming,
                    text = stringResource(R.string.upcoming_nav_item)
                )

                ButtonItem(
                    icon = Icons.Default.Search,
                    text = stringResource(R.string.search_nav_item)
                )

                ButtonItem(
                    icon = Icons.Default.Menu,
                    text = stringResource(R.string.browse_nav_item)
                )

                ButtonItem(
                    icon = Icons.Default.NotificationsNone,
                    text = stringResource(R.string.notifications_nav_item)
                )

                Button(onClick = {}) {
                    Row {
                        Icon(Icons.Default.Restore, contentDescription = null)
                        Text(stringResource(R.string.restore_defaults_button))
                    }
                }
            }
        }
    }
}

@Composable
fun DynamicAddButtonPlacementItem(
    position: DynamicAddButtonPlacement,
    isChecked: Boolean,
    onCheck: (position: DynamicAddButtonPlacement, isChecked: Boolean) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        //TODO: Image
        Text(position.toPrintedName())
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked ->
                onCheck(position, isChecked)
            }
        )
    }
}

@Composable
fun ButtonItem(icon: ImageVector, text: String) {
    ListItem(
        leadingContent = {
            Icon(icon, contentDescription = null)
        },
        headlineContent = {
            Text(text)
        },
        trailingContent = {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }
    )
}