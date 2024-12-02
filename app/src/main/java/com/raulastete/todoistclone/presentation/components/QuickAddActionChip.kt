package com.raulastete.todoistclone.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulastete.todoistclone.presentation.features.settings.quickadd.QuickAddActionModel

@Composable
fun QuickAddActionChip(action: QuickAddActionModel) {
    AssistChip(
        onClick = { },
        label = { Text(stringResource(action.name), fontSize = 12.sp) },
        leadingIcon = {
            Icon(
                imageVector = action.icon,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        },
        shape = RoundedCornerShape(4.dp)
    )
}

@Composable
fun DefaultQuickAddAction(){
    AssistChip(
        modifier = Modifier.padding(end = 16.dp),
        onClick = { },
        label = { Icon(imageVector = Icons.Default.MoreHoriz , contentDescription = null) },
        shape = RoundedCornerShape(4.dp)
    )
}