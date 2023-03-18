package co.jp.arcanium.mykanji.kanji.domain.util

import kotlinx.datetime.*

fun LocalDateTime.now(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}

fun LocalDateTime.toEpochMillis(): Long {
    return this.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
}

fun LocalDateTime.getFormattedString(): String {
    val month = this.month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
    val day = if(this.dayOfMonth < 10) "0${this.dayOfMonth}" else this.dayOfMonth
    val year = this.year
    val hour = if(this.hour < 10) "0${this.hour}" else this.hour
    val minute = if(this.minute < 10) "0${this.minute}" else this.minute

    return buildString {
        append(month)
        append(" ")
        append(day)
        append(" ")
        append(year)
        append(", ")
        append(hour)
        append(":")
        append(minute)
    }
}