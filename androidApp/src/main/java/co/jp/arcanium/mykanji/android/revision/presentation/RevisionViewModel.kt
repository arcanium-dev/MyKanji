package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jp.arcanium.mykanji.feature_revision.domain.use_case.GetKanjiRevisionSet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RevisionViewModel @Inject constructor(
    private val getKanjiRevisionSet: GetKanjiRevisionSet
)  : ViewModel() {
    private val _revisionState = MutableStateFlow(RevisionState())
    val revisionState = _revisionState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _revisionState.update {
                it.copy(kanjiRevisionSet = getKanjiRevisionSet(revisionSetLimit = 10))
            }
        }
    }
}