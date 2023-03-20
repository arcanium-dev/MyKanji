package co.jp.arcanium.mykanji.android.ui

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val MyKanjiLightColorScheme: ColorScheme = lightColorScheme(
    primary = Color(0xFF000000),
    surfaceVariant = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFA5F5F),
    onErrorContainer = Color(0xFFFFFFFF)
)
internal val MyKanjiDarkColorScheme: ColorScheme = darkColorScheme()

@Composable
internal fun myKanjiColorScheme(isSystemInDarkTheme: Boolean): ColorScheme
= if (isSystemInDarkTheme) MyKanjiDarkColorScheme else MyKanjiLightColorScheme