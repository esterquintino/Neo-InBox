package br.com.fiap.neoinbox.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Link(
    modifier: Modifier,
    text: String,
    fontfamily: FontFamily,
    fontsize: Int,
    textcolor: Color,
    textalign: TextAlign,
    onclick: (() -> Unit)? = null
) {
    Button(
        onClick = { onclick?.invoke() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = textcolor,
        ),
        modifier = modifier
        ) {
        Text(
            textAlign = textalign,
            text = text,
            fontFamily = fontfamily,
            fontSize = fontsize.sp
        )
    }
}