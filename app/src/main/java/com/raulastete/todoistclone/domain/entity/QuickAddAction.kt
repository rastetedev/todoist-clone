package com.raulastete.todoistclone.domain.entity

enum class QuickAddAction(val isPro: Boolean = false) {
    REMINDERS, PRIORITY, DUE_DATE, ASSIGNEE, LABELS, LOCATION(isPro = true)
}