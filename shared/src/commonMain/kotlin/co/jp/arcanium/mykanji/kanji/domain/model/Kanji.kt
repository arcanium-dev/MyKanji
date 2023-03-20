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
            Kanji(kanji = "七", meaning = "seven", hint = "", questionAnswerPair = null, onyomi = "shichi", kunyomi = "nana", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "八", meaning = "eight", hint = "", questionAnswerPair = null, onyomi = "hachi", kunyomi = "yatsu", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "九", meaning = "nine", hint = "", questionAnswerPair = null, onyomi = "kyuu", kunyomi = "kokonotsu", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "十", meaning = "ten", hint = "", questionAnswerPair = null, onyomi = "juu", kunyomi = "tou", incorrectCount = 0, createdAt = DateTimeUtil.now()),

            Kanji(kanji = "百", meaning = "hundred", hint = "", questionAnswerPair = null, onyomi = "hyaku", kunyomi = "mom", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "千", meaning = "thousand", hint = "", questionAnswerPair = null, onyomi = "sen", kunyomi = "chi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "万", meaning = "ten thousand", hint = "", questionAnswerPair = null, onyomi = "man", kunyomi = "bann", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "円", meaning = "Yen", hint = "", questionAnswerPair = null, onyomi = "en", kunyomi = "maru", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "口", meaning = "mouth", hint = "", questionAnswerPair = null, onyomi = "kou", kunyomi = "kuchi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "目", meaning = "eye", hint = "", questionAnswerPair = null, onyomi = "moku", kunyomi = "me", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "日", meaning = "Day", hint = "", questionAnswerPair = null, onyomi = "nichi", kunyomi = "hi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "月", meaning = "Moon", hint = "", questionAnswerPair = null, onyomi = "getsu", kunyomi = "tsuki", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "火", meaning = "fire", hint = "", questionAnswerPair = null, onyomi = "ka", kunyomi = "hi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "水", meaning = "water", hint = "", questionAnswerPair = null, onyomi = "sui", kunyomi = "mizu", incorrectCount = 0, createdAt = DateTimeUtil.now()),

            Kanji(kanji = "木", meaning = "Wood", hint = "", questionAnswerPair = null, onyomi = "ki", kunyomi = "moku", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "金", meaning = "Gold", hint = "", questionAnswerPair = null, onyomi = "kin", kunyomi = "kane", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "土", meaning = "Soil", hint = "", questionAnswerPair = null, onyomi = "do", kunyomi = "tsuchi", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "曜", meaning = "Weekday", hint = "", questionAnswerPair = null, onyomi = "yo", kunyomi = "", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "本", meaning = "Book", hint = "", questionAnswerPair = null, onyomi = "hon", kunyomi = "moto", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "人", meaning = "Person", hint = "", questionAnswerPair = null, onyomi = "jin", kunyomi = "hito", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "今", meaning = "Now", hint = "", questionAnswerPair = null, onyomi = "kon", kunyomi = "ima", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "寺", meaning = "Temple", hint = "", questionAnswerPair = null, onyomi = "ji", kunyomi = "tera", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "時", meaning = "Time", hint = "", questionAnswerPair = null, onyomi = "ji", kunyomi = "toki", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "半", meaning = "Half", hint = "", questionAnswerPair = null, onyomi = "han", kunyomi = "naka", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "刀", meaning = "sword", hint = "", questionAnswerPair = null, onyomi = "tou", kunyomi = "katana", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "分", meaning = "part", hint = "", questionAnswerPair = null, onyomi = "bun", kunyomi = "wake", incorrectCount = 0, createdAt = DateTimeUtil.now()),
            Kanji(kanji = "上", meaning = "above", hint = "", questionAnswerPair = null, onyomi = "jou", kunyomi = "ue", incorrectCount = 0, createdAt = DateTimeUtil.now()) ,
            Kanji(kanji = "下", meaning = "below", hint = "", questionAnswerPair = null, onyomi = "ka", kunyomi = "shita", incorrectCount = 0, createdAt = DateTimeUtil.now())
        )
    }
}
