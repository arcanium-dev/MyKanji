package co.jp.arcanium.mykanji.android.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

internal val MyKanjiLightColorScheme: ColorScheme = lightColorScheme()
internal val MyKanjiDarkColorScheme: ColorScheme = darkColorScheme()

@Composable
internal fun myKanjiColorScheme(): ColorScheme = if (isSystemInDarkTheme()) MyKanjiDarkColorScheme else MyKanjiLightColorScheme