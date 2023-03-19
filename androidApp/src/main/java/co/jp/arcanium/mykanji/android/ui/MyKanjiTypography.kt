package co.jp.arcanium.mykanji.android.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import co.jp.arcanium.mykanji.android.R

val regular = Font(R.font.regular)
val bold = Font(R.font.bold)
val medium = Font(R.font.medium)
val semiBold = Font(R.font.semi_bold)
val light = Font(R.font.light)

internal fun myKanjiTypography(): Typography {
    return Typography(
        displayMedium = TextStyle(
            fontFamily = FontFamily(bold),
            fontSize = 48.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = FontFamily(bold),
            fontSize = 28.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily(bold),
            fontSize = 16.sp
        ),
        labelMedium = TextStyle(
            fontFamily = FontFamily(light),
            fontSize = 16.sp
        )
    )
}
