package co.jp.arcanium.mykanji.kanji.domain.model

import kotlinx.datetime.LocalDateTime

data class Kanji(
    val kanji: String,
    val meaning: String,
    val onyomi: String?,
    val kunyomi: String?,
    val incorrectCount: Int?,
    val createdAt: LocalDateTime
)
