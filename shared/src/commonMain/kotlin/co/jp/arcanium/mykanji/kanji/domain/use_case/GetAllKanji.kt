package co.jp.arcanium.mykanji.kanji.domain.use_case

import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

class GetAllKanji constructor(
    private val localKanjiDataSource: LocalKanjiDataSource
) {
    suspend operator fun invoke(): List<Kanji> {
        return localKanjiDataSource.selectAllKanji()
    }
}