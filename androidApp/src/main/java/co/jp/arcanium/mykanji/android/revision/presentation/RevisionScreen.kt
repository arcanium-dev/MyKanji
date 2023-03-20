package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.jp.arcanium.mykanji.android.revision.RevisionRoute
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

@Composable
fun RevisionScreen(
    revisionState: RevisionState,
    onExitClicked: () -> Unit
) {
    var isKanjiHidden = rememberSaveable {
        mutableStateOf(true)
    }
    val revisionNavController = rememberNavController()
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

        // Add logic for different screens
        NavHost(
            navController = revisionNavController,
            startDestination = RevisionRoute.writeKanjiRoute
        ) {
            composable(RevisionRoute.writeKanjiRoute) {
                KanjiRecognitionContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = 2,
                    kanji = revisionState.kanjiRevisionSet
                        .getOrNull(revisionState.currentIndex) ?: Kanji.defaultKanjiList
                        .first().copy(kanji = "null"),
                    isKanjiHidden = isKanjiHidden.value,
                    onRevealClick = {
                        isKanjiHidden.value = true
                    },
                    onShowHint = {

                    },

                    )
            }
            composable(RevisionRoute.vocabRevision) {

            }
        }
    }
}

@Composable
fun KanjiRecognitionContent(
    modifier: Modifier = Modifier,
    elevation: Int,
    kanji: Kanji,
    isKanjiHidden: Boolean,
    onRevealClick: () -> Unit,
    onShowHint: () -> Unit
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1f),
            elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = kanji.meaning
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        onClick = onRevealClick,
        shape = RoundedCornerShape(percent = 30)
    ) {
        Text(
            text = "Reveal Kanji",
            style = MaterialTheme.typography.bodyMedium
        )
    }

}