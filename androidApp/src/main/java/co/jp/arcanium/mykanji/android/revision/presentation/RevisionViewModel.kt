package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jp.arcanium.mykanji.feature_revision.domain.use_case.GetKanjiRevisionSet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RevisionViewModel @Inject constructor(
    private val getKanjiRevisionSet: GetKanjiRevisionSet
)  : ViewModel() {

    private val _revisionState = MutableStateFlow(RevisionState())
    val revisionState = _revisionState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = RevisionState()
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _revisionState.update {
                it.copy(kanjiRevisionSet = getKanjiRevisionSet(revisionSetLimit = 10))
            }
        }
    }

    fun setIsKanjiHidden(isKanjiHidden: Boolean) {
        _revisionState.update { it.copy(isKanjiHidden = isKanjiHidden) }
    }

    fun onAnswerTextChange(answerText: String) {
        _revisionState.update {
            it.copy(
                questionState = it.questionState.copy(answerText = answerText)
            )
        }
    }

    fun onSubmitClick() {
        _revisionState.update { revisionState ->
            val currentQuestionIndex = revisionState.questionState.currentQuestionIndex
            revisionState.copy(
                questionState = revisionState.questionState.copy(
                    currentQuestionIndex = currentQuestionIndex + 1
                )
            )
        }
    }

    fun incrementKanjiRevisionIndex() {
        _revisionState.update { it.copy(currentIndex = it.currentIndex + 1) }
    }
}