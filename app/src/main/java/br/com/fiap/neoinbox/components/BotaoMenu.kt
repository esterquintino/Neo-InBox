package br.com.fiap.neoinbox.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.database.repository.ContaRepository

@Composable
fun BotaoMenu(navController: NavController) {
    var exibirMenu by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    Box(
        modifier = Modifier
            .size(32.dp)
            .clickable { exibirMenu = true },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.button_menu),
            contentDescription = "Menu"
        )
    }

    if (exibirMenu) {
        Dialog(onDismissRequest = { exibirMenu = false }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ) {
                MenuOverlay(navController) {
                    exibirMenu = false
                }
            }
        }
    }
}
