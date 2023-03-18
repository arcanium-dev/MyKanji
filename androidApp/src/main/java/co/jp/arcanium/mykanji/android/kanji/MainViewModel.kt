package co.jp.arcanium.mykanji.android.kanji

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji
import co.jp.arcanium.mykanji.kanji.domain.use_case.GetAllKanji
import co.jp.arcanium.mykanji.kanji.domain.use_case.InsertKanji
import co.jp.arcanium.mykanji.kanji.domain.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllKanji: GetAllKanji,
    private val insertKanji: InsertKanji
) : ViewModel() {
    val allKanji = MutableStateFlow<List<Kanji>>(listOf())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            insertKanji(
                Kanji(
                    kanji = "町",
                    meaning = "Town",
                    createdAt = DateTimeUtil.now(),
                    onyomi = null,
                    kunyomi = null,
                    incorrectCount = 0,
                )
            )
            insertKanji(
                Kanji(
                    kanji = "良",
                    meaning = "Good",
                    createdAt = DateTimeUtil.now(),
                    onyomi = null,
                    kunyomi = null,
                    incorrectCount = 0,
                )
            )
            insertKanji(
                Kanji(
                    kanji = "鳥",
                    meaning = "Bird",
                    createdAt = DateTimeUtil.now(),
                    onyomi = null,
                    kunyomi = null,
                    incorrectCount = 0,
                )
            )
            allKanji.emit(getAllKanji())
        }
    }
}