package com.raulastete.todoistclone.presentation.features.configuration.navigationbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.raulastete.todoistclone.R
import com.raulastete.todoistclone.domain.entity.DynamicAddButtonPlacement

@Composable
fun DynamicAddButtonPlacement.toPrintedName(): String {
    return when(this){
        DynamicAddButtonPlacement.LEFT -> stringResource(R.string.left)
        DynamicAddButtonPlacement.CENTER -> stringResource(R.string.center)
        DynamicAddButtonPlacement.RIGHT -> stringResource(R.string.right)
    }
}