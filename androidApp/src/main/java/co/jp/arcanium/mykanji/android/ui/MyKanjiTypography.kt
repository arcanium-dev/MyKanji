package co.jp.arcanium.mykanji.android.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import co.jp.arcanium.mykanji.android.R

val regular = Font(R.font.regular)
val bold = Font(R.font.bold)
val medium = Font(R.font.medium)
val semiBold = Font(R.font.semi_bold)
val light = Font(R.font.light)

@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontColor: Color = MaterialTheme.colorScheme.onSurface,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        fontFamily = FontFamily(regular),
        fontSize = fontSize.sp,
        color = fontColor,
        textAlign = textAlign
    )
}

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontColor: Color = MaterialTheme.colorScheme.onSurface,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(bold),
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        color = fontColor,
        textAlign = textAlign
    )
}

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontColor: Color = MaterialTheme.colorScheme.onSurface,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(medium),
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        color = fontColor,
        textAlign = textAlign
    )
}

@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontColor: Color = MaterialTheme.colorScheme.onSurface,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(semiBold),
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        color = fontColor,
        textAlign = textAlign
    )
}

@Composable
fun LightText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight,
    fontSize: Int,
    fontColor: Color,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(light),
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        color = fontColor,
        textAlign = textAlign
    )
}