package br.com.fiap.neoinbox.entrada

import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.BotaoMenu
import br.com.fiap.neoinbox.components.EmailCard
import br.com.fiap.neoinbox.database.repository.ContaRepository
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp

@Composable
fun EntradaScreen(navController: NavController, entradaScreenViewModel: EntradaScreenViewModel) {

    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    val userEmail by entradaScreenViewModel.userEmail.collectAsState(initial = "")
    val userSenha by entradaScreenViewModel.userSenha.collectAsState(initial = "")

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.areia)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ){
                BotaoMenu()
                // inserir imagem perfil
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "Olá, $userEmail",
                    fontSize = 20.sp
                )
                // Barra de pesquisa
                // Botão de filtros
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                for (i in 0..10){
                    EmailCard(){

                    }

                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun EntradaScreenPreview() {
//    EntradaScreen(navController = NavController, entradaScreenViewModel = EntradaScreenViewModel)
//}