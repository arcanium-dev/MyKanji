package co.jp.arcanium.mykanji.android.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable

@Composable
fun MyKanjiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = myKanjiColorScheme(),
        typography = myKanjiTypography(),
        shapes = Shapes(),
        content = content
    )
}
