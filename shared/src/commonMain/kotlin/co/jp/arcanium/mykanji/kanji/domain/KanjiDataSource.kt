package co.jp.arcanium.mykanji.kanji.domain

import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

interface KanjiDataSource {
    fun insertKanji(kanji: Kanji)
    fun selectAllKanji(): List<Kanji>
    fun selectKanji(kanji: String): Kanji?
    fun selectRecentKanji(limit: Long): List<Kanji>
    fun deleteKanji(kanji: Kanji)
    fun updateKanji(kanji: Kanji)
}