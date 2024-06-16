package br.com.fiap.neoinbox.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R

@Composable
fun BotaoVoltar(
    modifier: Modifier,
    onclick: (() -> Unit)? = null
) {
    Button(
        onClick = { onclick?.invoke() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.voltar),
            contentDescription = "ícone de seta apontando para esquerda",
            modifier = Modifier
                .size(32.dp)
        )
    }
}