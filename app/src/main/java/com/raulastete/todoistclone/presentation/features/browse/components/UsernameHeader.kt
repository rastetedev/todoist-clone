package com.raulastete.todoistclone.presentation.features.browse.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.todoistclone.presentation.theme.TodoistCloneTheme

@Composable
fun UsernameHeader(
    username: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(color = Color.Blue.copy(alpha = 0.35f), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (username.isNotEmpty()) username.first().uppercase() else "-",
                fontSize = MaterialTheme.typography.labelSmall.fontSize
            )
        }
        Spacer(Modifier.width(8.dp))
        Text(text = username, fontSize = MaterialTheme.typography.titleLarge.fontSize)
    }
}

@Preview(showBackground = true)
@Composable
private fun UsernameHeaderPreview() {
    TodoistCloneTheme {
        UsernameHeader(
            username = "raulastete.2215",
            modifier = Modifier.fillMaxWidth()
        )
    }
}