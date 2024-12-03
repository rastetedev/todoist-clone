package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.entity.BottomItem
import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement
import com.raulastete.todoistclone.presentation.components.SectionTitle
import com.raulastete.todoistclone.presentation.core.models.BottomItemModel

@Composable
fun NavigationBarConfigScreen(
    navigationBarConfigViewModel: NavigationBarConfigViewModel,
    onNavigateBack: () -> Unit
) {
    val navigationBarUiState by navigationBarConfigViewModel.uiState.collectAsStateWithLifecycle()

    NavigationBarContent(
        navigationBarConfigUiState = navigationBarUiState,
        onNavigateBack = onNavigateBack,
        sendIntent = navigationBarConfigViewModel::onIntent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarContent(
    navigationBarConfigUiState: NavigationBarConfigUiState,
    onNavigateBack: () -> Unit,
    sendIntent: (NavigationBarConfigIntent) -> Unit
) {
    with(navigationBarConfigUiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(stringResource(R.string.navigation_bar_screen_title))
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
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(R.string.navigation_bar_headline),
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(R.string.dynamic_add_button_title),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(32.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(Modifier.weight(1f))

                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.LEFT,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.LEFT,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarConfigIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )

                    Spacer(Modifier.width(32.dp))

                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.CENTER,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.CENTER,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarConfigIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )

                    Spacer(Modifier.width(32.dp))

                    DynamicAddButtonPlacementItem(
                        position = DynamicAddButtonPlacement.RIGHT,
                        isChecked = dynamicAddButtonPlacementChecked == DynamicAddButtonPlacement.RIGHT,
                        onCheck = { position, isChecked ->
                            sendIntent(
                                NavigationBarConfigIntent.ChangeDynamicAddButtonPlacement(
                                    position, isChecked
                                )
                            )
                        }
                    )

                    Spacer(Modifier.weight(1f))
                }

                Spacer(Modifier.height(32.dp))

                HorizontalDivider()

                SectionTitle(
                    modifier = Modifier.padding(16.dp), //TODO: Refactor later to only send missing modifier
                    text = stringResource(R.string.buttons_title)
                )

                bottomItemsArranged.forEach { bottomItemModel ->
                    ButtonItem(
                        bottomItemModel = bottomItemModel,
                        onClickMoreOptions = {

                        }
                    )
                }

                HorizontalDivider()

                ListItem(
                    leadingContent = {
                        Icon(Icons.Default.Add, contentDescription = null)
                    },
                    headlineContent = {
                        Text(stringResource(R.string.add_button))
                    }
                )

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 32.dp),
                    onClick = {}
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Restore, contentDescription = null)
                        Spacer(Modifier.width(16.dp))
                        Text(stringResource(R.string.restore_defaults_button).uppercase())
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
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TODO: Image
        Text(position.toPrintedName())
        RadioButton(
            selected = isChecked,
            onClick = {
                onCheck(position, isChecked)
            }
        )
    }
}

@Composable
fun ButtonItem(
    bottomItemModel: BottomItemModel,
    onClickMoreOptions: (BottomItemModel) -> Unit,
) {
    ListItem(
        leadingContent = {
            Icon(bottomItemModel.icon, contentDescription = null)
        },
        headlineContent = {
            Text(stringResource(bottomItemModel.label))
        },
        trailingContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (bottomItemModel.key != BottomItem.BROWSE) {
                    IconButton(onClick = { onClickMoreOptions(bottomItemModel) }) {
                        Icon(Icons.Default.MoreVert, contentDescription = null)
                    }
                }
                IconButton(onClick = { onClickMoreOptions(bottomItemModel) }) {
                    Icon(Icons.Default.Reorder, contentDescription = null)
                }
            }
        }
    )
}