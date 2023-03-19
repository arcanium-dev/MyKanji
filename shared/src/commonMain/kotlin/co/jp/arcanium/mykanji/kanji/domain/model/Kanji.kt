package co.jp.arcanium.mykanji.kanji.domain.model

import co.jp.arcanium.mykanji.kanji.domain.util.DateTimeUtil
import kotlinx.datetime.LocalDateTime

data class Kanji(
    val kanji: String,
    val meaning: String,
    val onyomi: String?,
    val kunyomi: String?,
    val incorrectCount: Int?,
    val createdAt: LocalDateTime
) {
    companion object {
        val defaultKanjiList = listOf(
            Kanji("一", "one", "ichi", "hito", 0, DateTimeUtil.now()),
            Kanji("二", "two", "ni", "futa", 0, DateTimeUtil.now()),
            Kanji("三", "three", "san", "mi", 0, DateTimeUtil.now()),
            Kanji("四", "four", "shi", "yon", 0, DateTimeUtil.now()),
            Kanji("五", "five", "go", "itsu", 0, DateTimeUtil.now()),
            Kanji("六", "six", "roku", "mu", 0, DateTimeUtil.now()),
            Kanji("七", "seven", "shichi", "nana", 0, DateTimeUtil.now()),
            Kanji("八", "eight", "hachi", "ya", 0, DateTimeUtil.now()),
            Kanji("九", "nine", "kyuu", "koko", 0, DateTimeUtil.now()),
            Kanji("十", "ten", "juu", "to", 0, DateTimeUtil.now()),
            Kanji("日", "day", "nichi", "hi", 0, DateTimeUtil.now()),
            Kanji("月", "month", "getsu", "tsuki", 0, DateTimeUtil.now()),
            Kanji("火", "fire", "ka", "hi", 0, DateTimeUtil.now()),
            Kanji("水", "water", "sui", "mizu", 0, DateTimeUtil.now()),
            Kanji("木", "tree", "moku", "ki", 0, DateTimeUtil.now()),
            Kanji("金", "gold", "kin", "kane", 0, DateTimeUtil.now()),
            Kanji("土", "earth", "do", "tsuchi", 0, DateTimeUtil.now()),
            Kanji("本", "book", "hon", "moto", 0, DateTimeUtil.now()),
            Kanji("人", "person", "jin", "hito", 0, DateTimeUtil.now()),
            Kanji("年", "year", "nen", "toshi", 0, DateTimeUtil.now())
        )
    }
}
