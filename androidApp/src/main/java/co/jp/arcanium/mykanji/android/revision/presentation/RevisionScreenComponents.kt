package co.jp.arcanium.mykanji.android.revision.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jp.arcanium.mykanji.android.ui.MyKanjiTheme

@Composable
fun RevisionScreenTopBar(
    onExitClicked: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterStart)
                .clickable(onClick = onExitClicked),
            text = "Exit",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Revision",
            style = MaterialTheme.typography.headlineSmall
        )

    }
}

@Preview
@Composable
private fun PreviewRevisionScreenTopBar() {
    MyKanjiTheme {
        RevisionScreenTopBar(onExitClicked = {})
    }
}