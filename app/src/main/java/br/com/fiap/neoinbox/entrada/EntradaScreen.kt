package br.com.fiap.neoinbox.entrada

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.BotaoMenu

@Composable
fun EntradaScreen(navController: NavController, entradaScreenViewModel: EntradaScreenViewModel) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.areia)),
        contentAlignment = Alignment.Center
    ){
        Column(){
            BotaoMenu()
        }
    }
}