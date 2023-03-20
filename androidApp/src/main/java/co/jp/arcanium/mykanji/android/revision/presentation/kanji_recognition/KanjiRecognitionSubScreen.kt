package co.jp.arcanium.mykanji.android.revision.presentation.kanji_recognition

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.jp.arcanium.mykanji.android.ui.BoldText
import co.jp.arcanium.mykanji.android.ui.MediumText
import co.jp.arcanium.mykanji.android.ui.SemiBoldText
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

@Composable
fun KanjiRecognitionSubScreen(
    modifier: Modifier = Modifier,
    elevation: Int,
    kanji: Kanji,
    isKanjiHidden: Boolean,
    onRevealClick: () -> Unit,
    onShowHint: () -> Unit,
    onIncorrectClicked: () -> Unit,
    onCorrectClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1f),
            elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                BoldText(
                    modifier = Modifier.align(Alignment.Center),
                    text = if (isKanjiHidden) kanji.meaning else kanji.kanji,
                    fontSize = 48,
                    fontColor = MaterialTheme.colorScheme.primary
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (isKanjiHidden) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onClick = onRevealClick,
                shape = RoundedCornerShape(percent = 30)
            ) {
                SemiBoldText(
                    text = "Reveal Kanji",
                    fontSize = 16,
                    fontColor = MaterialTheme.colorScheme.onPrimary
                )
            }
            MediumText(
                modifier = Modifier.clickable(onClick = onShowHint),
                text = "Show hint",
                fontSize = 16
            )
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    onClick = onIncorrectClicked,
                    shape = RoundedCornerShape(percent = 30),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    SemiBoldText(
                        text = "Incorrect",
                        fontSize = 16,
                        fontColor = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    onClick = onCorrectClicked,
                    shape = RoundedCornerShape(percent = 30)
                ) {
                    SemiBoldText(
                        text = "Correct",
                        fontSize = 16,
                        fontColor = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }

    }
}