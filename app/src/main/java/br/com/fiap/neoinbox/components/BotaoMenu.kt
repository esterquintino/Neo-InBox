package br.com.fiap.neoinbox.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.fiap.neoinbox.R

@Composable
fun BotaoMenu() {
    var exibirMenu by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(56.dp)
            .clickable { exibirMenu = true },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "Menu"
        )
    }

    if (exibirMenu) {
        Dialog(onDismissRequest = { exibirMenu = false }) {
            MenuOverlay{
                exibirMenu = false
            }
        }
    }
}