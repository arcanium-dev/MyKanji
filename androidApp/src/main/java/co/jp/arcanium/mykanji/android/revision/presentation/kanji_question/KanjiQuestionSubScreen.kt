package co.jp.arcanium.mykanji.android.revision.presentation.kanji_question

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import co.jp.arcanium.mykanji.android.ui.BoldText
import co.jp.arcanium.mykanji.android.ui.RegularText
import co.jp.arcanium.mykanji.android.ui.SemiBoldText
import co.jp.arcanium.mykanji.kanji.domain.model.KanjiQuestion
import kotlinx.coroutines.delay

@Composable
fun KanjiQuestionSubScreen(
    modifier: Modifier,
    elevation: Int,
    currentQuestionIndex: Int,
    answerText: String,
    onAnswerTextChange: (String) -> Unit,
    questionList: List<KanjiQuestion>,
    onSubmitClick: () -> Unit,
    navigateToOverview: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(timeMillis = 3_000L)
        if (questionList.isEmpty()) navigateToOverview()
    }
    if (questionList.isEmpty()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
            .alpha(0.5f)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .align(Alignment.Center)
            )
        }

    } else {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(70.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp)
            ) {
                Column {
                    BoldText(text = "Question ${currentQuestionIndex + 1}", fontSize = 16)
                    RegularText(text = questionList[currentQuestionIndex].question , fontSize = 16)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(70.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp)
            ) {
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    value = answerText,
                    onValueChange = onAnswerTextChange
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 20.dp),
                onClick = {
                    if (currentQuestionIndex + 1 == questionList.size) {
                        navigateToOverview()
                    } else {
                        onSubmitClick()
                    }
                },
                shape = RoundedCornerShape(percent = 30)
            ) {
                SemiBoldText(
                    text = "Submit",
                    fontSize = 16,
                    fontColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

}