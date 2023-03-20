package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.jp.arcanium.mykanji.android.revision.RevisionRoute
import co.jp.arcanium.mykanji.android.revision.presentation.kanji_question.KanjiQuestionSubScreen
import co.jp.arcanium.mykanji.android.revision.presentation.kanji_recognition.KanjiRecognitionSubScreen
import co.jp.arcanium.mykanji.android.ui.BoldText
import co.jp.arcanium.mykanji.android.ui.SemiBoldText
import co.jp.arcanium.mykanji.kanji.domain.model.Kanji

@Composable
fun RevisionScreen(
    revisionState: RevisionState,
    onExitClicked: () -> Unit,
    setIsKanjiHidden: (Boolean) -> Unit,
    onAnswerTextChange: (String) -> Unit,
    incrementKanjiRevisionIndex: () -> Unit,
    onSubmitClick: () -> Unit
) {
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
                LaunchedEffect(Unit) {
                    setIsKanjiHidden(true)
                }
                KanjiRecognitionSubScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = 2,
                    kanji = revisionState.kanjiRevisionSet
                        .getOrNull(revisionState.currentIndex) ?: Kanji.defaultKanjiList
                        .first().copy(kanji = "null"),
                    isKanjiHidden = revisionState.isKanjiHidden,
                    onRevealClick = {
                        setIsKanjiHidden(false)
                    },
                    onShowHint = {},
                    onIncorrectClicked = {
                        revisionNavController.navigate(RevisionRoute.vocabRevision)
                    },
                    onCorrectClicked = {
                        revisionNavController.navigate(RevisionRoute.vocabRevision)
                    },
                )
            }
            composable(RevisionRoute.vocabRevision) {
                KanjiQuestionSubScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = 2,
                    currentQuestionIndex = revisionState.currentIndex,
                    answerText = revisionState.questionState.answerText,
                    onAnswerTextChange = onAnswerTextChange,
                    questionList = revisionState.questionState.questionList,
                    onSubmitClick = onSubmitClick,
                    navigateToOverview = {
                        revisionNavController.navigate(RevisionRoute.overview)
                    },
                )
            }

            composable(RevisionRoute.overview) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(horizontal = 20.dp),
                        onClick = {
                            if (revisionState.currentIndex + 1 == revisionState.kanjiRevisionSet.size) {
                                onExitClicked()
                            } else {
                                incrementKanjiRevisionIndex()
                                revisionNavController.navigate(RevisionRoute.writeKanjiRoute)
                            }
                        },
                        shape = RoundedCornerShape(percent = 30)
                    ) {
                        SemiBoldText(
                            text = "Next",
                            fontSize = 16,
                            fontColor = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }
}