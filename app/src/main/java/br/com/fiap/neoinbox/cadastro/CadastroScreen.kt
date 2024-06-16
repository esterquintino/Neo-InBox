package br.com.fiap.neoinbox.cadastro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Fundo

@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {
    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val sobrenome by cadastroScreenViewModel.sobrenome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
    val nrtelefone by cadastroScreenViewModel.nrtelefone.observeAsState(initial = "")
    var inputText by remember { mutableStateOf(nrtelefone.toString()) }

    Fundo(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ){
        CaixaDeEntrada(
            label = "Digite seu nome",
            placeholder = "Nome",
            value = nome,
            keyboardType = KeyboardType.Text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            atualizarValor = {
                cadastroScreenViewModel.onNomeChanged(it)
            }
        )
        CaixaDeEntrada(
            label = "Digite seu sobrenome",
            placeholder = "Sobrenome",
            value = sobrenome,
            keyboardType = KeyboardType.Text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            atualizarValor = {
                cadastroScreenViewModel.onSobrenomeChanged(it)
            }
        )
        CaixaDeEntrada(
            label = "Digite um endereço de email",
            placeholder = "Endereço de email",
            value = email,
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            atualizarValor = {
                cadastroScreenViewModel.onEmailChanged(it)
            }
        )
        CaixaDeEntrada(
            label = "Digite sua senha",
            placeholder = "Senha",
            value = senha,
            keyboardType = KeyboardType.Password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            atualizarValor = {
                cadastroScreenViewModel.onSenhaChanged(it)
            }
        )
        CaixaDeEntrada(
            label = "Digite seu número de telefone",
            placeholder = "Telefone",
            value = inputText,
            keyboardType = KeyboardType.Decimal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            atualizarValor = {
                inputText = it
                val longNrTelefone = it.toLongOrNull() ?: 0
                cadastroScreenViewModel.onNrTelefoneChanged(longNrTelefone)
            }
        )

    }
}