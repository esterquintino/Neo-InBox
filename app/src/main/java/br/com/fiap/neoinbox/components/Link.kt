package br.com.fiap.neoinbox.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Link(
    modifier: Modifier,
    text: String,
    fontfamily: FontFamily,
    fontsize: Int,
    onclick: String
) {
    Button(
        onClick = { "" },
        modifier = modifier
        ) {
        Text(
            text = text,
            fontFamily = fontfamily,
            fontSize = fontsize.sp
        )
    }
}