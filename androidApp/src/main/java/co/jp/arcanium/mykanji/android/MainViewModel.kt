package co.jp.arcanium.mykanji.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localKanjiDataSource: LocalKanjiDataSource
) : ViewModel() {


    fun setup() {
        viewModelScope.launch {
            Kanji.defaultKanjiList.forEach {
                localKanjiDataSource.insertKanji(it)
            }
        }
    }
}