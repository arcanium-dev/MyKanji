package co.jp.arcanium.mykanji.android.revision.presentation.kanji_question

import co.jp.arcanium.mykanji.kanji.domain.model.KanjiQuestion

data class QuestionState(
    val answerText: String = "",
    val currentQuestionIndex: Int = 0,
    val questionList: List<KanjiQuestion> = listOf()
)