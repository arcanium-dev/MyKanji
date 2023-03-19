package co.jp.arcanium.mykanji.feature_revision.domain.use_case

import co.jp.arcanium.mykanji.kanji.domain.AppPreferences
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

class GetKanjiRevisionSet constructor(
    private val localKanjiDataSource: LocalKanjiDataSource,
    private val preferences: AppPreferences
) {
    suspend operator fun invoke(
        revisionSetLimit: Int = preferences.getInt("revision_set_size") ?: 20
    ): List<Kanji> {
        val localKanjiDataSet = localKanjiDataSource.selectAllKanji()
        if (revisionSetLimit >= localKanjiDataSet.size) return localKanjiDataSet.shuffled()
        return localKanjiDataSet.take(revisionSetLimit).shuffled()
    }
}