package co.jp.arcanium.mykanji.android.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

@Composable
fun MyKanjiTheme(
    isSystemInDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = myKanjiColorScheme(isSystemInDarkMode),
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
