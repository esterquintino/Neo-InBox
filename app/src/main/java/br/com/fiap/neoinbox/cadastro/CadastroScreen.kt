package br.com.fiap.neoinbox.cadastro

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.Fundo
import androidx.compose.ui.Modifier

@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {
    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val sobrenome by cadastroScreenViewModel.sobrenome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
    val nrtelefone by cadastroScreenViewModel.nrtelefone.observeAsState(initial = "")

    Fundo(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Teste de cadastro")
    }
}