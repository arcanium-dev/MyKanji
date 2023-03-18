package co.jp.arcanium.mykanji.kanji.domain

import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

interface KanjiDataSource {
    suspend fun insertKanji(kanji: Kanji)
    suspend fun selectAllKanji(): List<Kanji>
    suspend fun selectKanji(kanji: String): Kanji?
    suspend fun deleteKanji(kanji: Kanji)
    suspend fun updateKanji(kanji: Kanji)
}