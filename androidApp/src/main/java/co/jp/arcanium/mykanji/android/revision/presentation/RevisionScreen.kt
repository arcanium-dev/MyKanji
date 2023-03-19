package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jp.arcanium.mykanji.android.ui.MyKanjiTheme
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

@Composable
fun RevisionScreen(
    revisionState: RevisionState,
    onExitClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        RevisionScreenTopBar(onExitClicked = onExitClicked)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "${revisionState.currentIndex + 1}/${revisionState.kanjiRevisionSet.size}",
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        KanjiRecognitionContent(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            kanji = revisionState.kanjiRevisionSet.getOrNull(revisionState.currentIndex) ?: Kanji.defaultKanjiList.first().copy(kanji = "null")
        )
            
    }
}

@Composable
fun KanjiRecognitionContent(
    modifier: Modifier = Modifier,
    kanji: Kanji
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Text(
            text = kanji.kanji,
        )
    }
}