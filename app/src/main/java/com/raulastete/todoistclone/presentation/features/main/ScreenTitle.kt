package com.raulastete.todoistclone.presentation.features.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.raulastete.todoistclone.domain.entity.BottomItem
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.presentation.features.browse.components.UsernameHeader

@Composable
fun BottomItem.ScreenTitle() =
    when (this) {
        BottomItem.TODAY -> { Text(stringResource(R.string.today_screen_title)) }
        BottomItem.UPCOMING -> Text(stringResource(R.string.upcoming_screen_title))
        BottomItem.FILTERS_N_LABELS -> Text(stringResource(R.string.filters_n_labels_screen_title))
        BottomItem.SEARCH -> Text(stringResource(R.string.search_screen_title))
        BottomItem.BROWSE -> UsernameHeader(username = "raulastete")
        BottomItem.NOTIFICATIONS -> Text(stringResource(R.string.notifications_screen_title))
        BottomItem.INBOX -> Text(stringResource(R.string.inbox_screen_title))
    }