package com.raulastete.todoistclone.presentation.features.settings.list

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.BorderBottom
import androidx.compose.material.icons.filled.FormatPaint
import androidx.compose.material.icons.filled.InvertColors
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.MoveUp
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulastete.todoistclone.R

@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToAccountSettings: () -> Unit,
    onNavigateToGeneralSettings: () -> Unit,
    onNavigateToThemeSettings: () -> Unit,
    onNavigateToAppIconSettings: () -> Unit,
    onNavigateToNavigationBarSettings: () -> Unit,
    onNavigateToQuickAddSettings: () -> Unit,
    onNavigateToProductivitySettings: () -> Unit,
    onNavigateToRemindersSettings: () -> Unit,
    onNavigateToNotificationsSettings: () -> Unit,
) {
    SettingsContent(
        onNavigateBack = onNavigateBack,
        onNavigateToAccountSettings = onNavigateToAccountSettings,
        onNavigateToGeneralSettings = onNavigateToGeneralSettings,
        onNavigateToThemeSettings = onNavigateToThemeSettings,
        onNavigateToAppIconSettings = onNavigateToAppIconSettings,
        onNavigateToNavigationBarSettings = onNavigateToNavigationBarSettings,
        onNavigateToQuickAddSettings = onNavigateToQuickAddSettings,
        onNavigateToProductivitySettings = onNavigateToProductivitySettings,
        onNavigateToRemindersSettings = onNavigateToRemindersSettings,
        onNavigateToNotificationsSettings = onNavigateToNotificationsSettings,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsContent(
    onNavigateBack: () -> Unit,
    onNavigateToAccountSettings: () -> Unit,
    onNavigateToGeneralSettings: () -> Unit,
    onNavigateToThemeSettings: () -> Unit,
    onNavigateToAppIconSettings: () -> Unit,
    onNavigateToNavigationBarSettings: () -> Unit,
    onNavigateToQuickAddSettings: () -> Unit,
    onNavigateToProductivitySettings: () -> Unit,
    onNavigateToRemindersSettings: () -> Unit,
    onNavigateToNotificationsSettings: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = { Text(stringResource(R.string.setting_screen_title)) }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            SettingsSection(
                headerResource = null,
                settingItems = listOf(
                    SettingItemModel(
                        icon = Icons.Default.AccountCircle,
                        nameResource = R.string.account_settings,
                        onClick = onNavigateToAccountSettings
                    ),
                    SettingItemModel(
                        icon = Icons.Default.Settings,
                        nameResource = R.string.general_settings,
                        onClick = onNavigateToGeneralSettings
                    )
                )
            )

            SettingsSection(
                headerResource = R.string.personalization_section_settings,
                settingItems = listOf(
                    SettingItemModel(
                        icon = Icons.Default.FormatPaint,
                        nameResource = R.string.theme_settings,
                        onClick = onNavigateToThemeSettings
                    ),
                    SettingItemModel(
                        icon = Icons.Default.InvertColors,
                        nameResource = R.string.app_icon_settings,
                        onClick = onNavigateToAppIconSettings

                    ),
                    SettingItemModel(
                        icon = Icons.Default.BorderBottom,
                        nameResource = R.string.navigation_bar_settings,
                        onClick = onNavigateToNavigationBarSettings
                    ),
                    SettingItemModel(
                        icon = Icons.Default.AddHome,
                        nameResource = R.string.quick_add_settings,
                        onClick = onNavigateToQuickAddSettings
                    )
                )
            )

            SettingsSection(
                headerResource = R.string.productivity_section_settings,
                settingItems = listOf(
                    SettingItemModel(
                        icon = Icons.Default.MoveUp,
                        nameResource = R.string.productivity_settings,
                        onClick = onNavigateToProductivitySettings
                    ),
                    SettingItemModel(
                        icon = Icons.Default.LockClock,
                        nameResource = R.string.reminders_settings,
                        onClick = onNavigateToRemindersSettings
                    ),
                    SettingItemModel(
                        icon = Icons.Default.NotificationsNone,
                        nameResource = R.string.notifications_settings,
                        onClick = onNavigateToNotificationsSettings
                    ),
                )
            )

            SettingsSection(
                headerResource = R.string.more_section_settings,
                settingItems = listOf(
                    SettingItemModel(
                        icon = Icons.AutoMirrored.Filled.Logout,
                        nameResource = R.string.logout_settings,
                        onClick = {
                            //TODO: Implement Log Out
                        }
                    ),
                ),
                hasDivider = false
            )
        }
    }
}

@Composable
private fun SettingsSection(
    @StringRes headerResource: Int?,
    settingItems: List<SettingItemModel>,
    hasDivider: Boolean = true
) {

    Column {
        headerResource?.let {
            SectionTitle(textResource = headerResource)
        }
        settingItems.forEach {
            SettingsItem(icon = it.icon, nameResource = it.nameResource, onClick = it.onClick)
        }
        if (hasDivider) {
            HorizontalDivider()
        }
    }
}

@Composable
private fun SectionTitle(@StringRes textResource: Int) {
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp),
        text = stringResource(textResource),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun SettingsItem(icon: ImageVector, @StringRes nameResource: Int, onClick: () -> Unit) {

    ListItem(
        modifier = Modifier.clickable { onClick() },
        leadingContent = {
            Icon(
                icon,
                contentDescription = null
            )
        },
        headlineContent = { Text(stringResource(nameResource)) },
    )
}

data class SettingItemModel(
    val icon: ImageVector,
    @StringRes val nameResource: Int,
    val value: String? = null,
    val onClick: () -> Unit
)