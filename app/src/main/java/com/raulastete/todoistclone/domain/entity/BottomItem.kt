package com.raulastete.todoistclone.domain.entity

enum class BottomItem(val visible: Boolean, val orderPosition: Int, val isPinned: Boolean = false) {

    TODAY(visible = true, orderPosition = 1),
    UPCOMING(visible = true, orderPosition = 1),
    FILTERS_N_LABELS(visible = true, orderPosition = 1),
    SEARCH(visible = true, orderPosition = 1),
    BROWSE(visible = true, orderPosition = 1, isPinned = true),
    NOTIFICATIONS(visible = true, orderPosition = 1),
    INBOX(visible = true, orderPosition = 1);
}