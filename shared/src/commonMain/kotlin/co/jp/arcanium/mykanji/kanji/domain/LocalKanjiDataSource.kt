package co.jp.arcanium.mykanji.kanji.domain

import co.jp.arcanium.mykanji.kanji.domain.model.Kanji
import co.jp.arcanium.mykanji.kanji.domain.model.KanjiQuestion

interface LocalKanjiDataSource {
    // Kanji-related methods
    suspend fun insertKanji(kanji: Kanji)
    suspend fun selectAllKanji(): List<Kanji>
    suspend fun selectKanji(kanji: String): Kanji?
    suspend fun deleteKanji(kanji: Kanji)
    suspend fun updateKanji(kanji: Kanji)

    // VocabQuestion-related methods
    suspend fun insertVocabQuestion(kanji: String, kanjiQuestion: KanjiQuestion)
    suspend fun selectVocabQuestions(kanji: String): List<KanjiQuestion>
    suspend fun deleteVocabQuestion(kanjiQuestion: KanjiQuestion)
}