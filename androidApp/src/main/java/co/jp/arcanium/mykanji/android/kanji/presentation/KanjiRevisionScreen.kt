package co.jp.arcanium.mykanji.android.kanji.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

@Composable
fun KanjiRevisionScreen(
    kanjiRevisionList: List<Kanji>
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

