package co.jp.arcanium.mykanji.android.revision.presentation

import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

data class RevisionState(
    val currentIndex: Int = 0,
    val kanjiRevisionSet: List<Kanji> = listOf()
)
