package co.jp.arcanium.mykanji.kanji.data

import co.jp.arcanium.mykanji.database.KanjiDatabase
import co.jp.arcanium.mykanji.kanji.domain.KanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji
import co.jp.arcanium.mykanji.kanji.domain.util.DateTimeUtil
import database.Kanji_table
import kotlinx.datetime.Instant
import kotlinx.datetime.toLocalDateTime

class SqlDelightKanjiDataSource(
    database: KanjiDatabase
) : KanjiDataSource {
    private val queries = database.kanjiQueries

    override suspend fun insertKanji(kanji: Kanji) {
        queries.insertKanji(
            kanji = kanji.kanji,
            meaning = kanji.meaning,
            onyomi = kanji.onyomi,
            kunyomi = kanji.kunyomi,
            createdAt = DateTimeUtil.toEpochMillis(kanji.createdAt)
        )
    }

    override suspend fun selectAllKanji(): List<Kanji> {
        return queries.selectAllKanji().executeAsList().map { it.toKanji() }
    }

    override suspend fun selectKanji(kanji: String): Kanji? {
        return queries.selectKanji(kanji = kanji).executeAsOneOrNull()?.toKanji()
    }

    override suspend fun deleteKanji(kanji: Kanji) {
        queries.deleteKanji(kanji = kanji.kanji)
    }

    override suspend fun updateKanji(kanji: Kanji) {
        queries.updateKanji(
            meaning = kanji.kanji,
            onyomi = kanji.onyomi,
            kunyomi = kanji.kunyomi,
            incorrectCount = kanji.incorrectCount?.toLong() ?: 0,
            kanji = kanji.kanji
        )
    }
}

fun Kanji_table.toKanji(): Kanji {
    return Kanji(
        kanji = this.kanji,
        meaning = this.meaning,
        onyomi = this.onyomi,
        kunyomi = this.kunyomi,
        incorrectCount = this.incorrectCount.toInt(),
        createdAt = Instant
            .fromEpochMilliseconds(createdAt)
            .toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault())
    )
}