package br.com.fiap.neoinbox.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.neoinbox.R

@Composable
fun IconeUsuario(
    modifier: Modifier,
    onclick: (() -> Unit)? = null
) {
    Button(
        onClick = { onclick?.invoke() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "ícone de usuário",
            modifier = Modifier
                .size(64.dp),
        )
    }
}