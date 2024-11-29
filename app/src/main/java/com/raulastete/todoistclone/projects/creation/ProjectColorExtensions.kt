package com.raulastete.todoistclone.projects.creation

import androidx.compose.ui.graphics.Color
import com.raulastete.todoistclone.domain.entity.ProjectColor

fun ProjectColor.drawColor(): Color {
    return when (this) {
        ProjectColor.RED -> Color.Red
        ProjectColor.ORANGE -> Color.Red.copy(alpha = 0.5f)
        ProjectColor.YELLOW -> Color.Yellow
        ProjectColor.GREEN -> Color.Green
        ProjectColor.BLUE -> Color.Blue
        ProjectColor.PURPLE -> Color.Magenta
        ProjectColor.PINK -> Color.Magenta.copy(alpha = 0.5f)
        ProjectColor.GRAY -> Color.Gray
    }
}

fun ProjectColor.toPrintedName(): String = this.name.lowercase().replaceFirstChar { it.uppercase() }