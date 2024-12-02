package com.raulastete.todoistclone.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulastete.todoistclone.presentation.theme.Pro

@Composable
fun ProBadge(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .background(
                color = Pro.copy(alpha = 0.1f),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 4.dp, vertical = 2.dp),
        text = "PRO",
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = Pro
    )
}
