package co.jp.arcanium.mykanji.kanji.domain.model

import co.jp.arcanium.mykanji.kanji.domain.util.DateTimeUtil
import kotlinx.datetime.LocalDateTime

data class Kanji(
    val kanji: String,
    val meaning: String,
    val hint: String,
    val questionAnswerPair: KanjiQuestion?,
    val onyomi: String?,
    val kunyomi: String?,
    val incorrectCount: Int?,
    val createdAt: LocalDateTime
) {
    companion object {
        val defaultKanjiList = listOf(
            Kanji(kanji = "一", meaning = "one", hint = "", questionAnswerPair = null, onyomi = "ichi", kunyomi = "hito", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "二", meaning = "two", hint = "", questionAnswerPair = null, onyomi = "ni", kunyomi = "futa", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "三", meaning = "three", hint = "", questionAnswerPair = null, onyomi = "san", kunyomi = "mi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "四", meaning = "four", hint = "", questionAnswerPair = null, onyomi = "shi", kunyomi = "yon", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "五", meaning = "five", hint = "", questionAnswerPair = null, onyomi = "go", kunyomi = "itsu", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "六", meaning = "six", hint = "", questionAnswerPair = null, onyomi = "roku", kunyomi = "mu", incorrectCount = 0, createdAt = DateTimeUtil.now()),
        )
    }
}
