package br.com.fiap.neoinbox.cadastro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Fundo
import br.com.fiap.neoinbox.components.Botao
import br.com.fiap.neoinbox.components.BotaoVoltar
import br.com.fiap.neoinbox.database.repository.ContaRepository

@Composable
fun CadastroScreen(navController: NavController, cadastroScreenViewModel: CadastroScreenViewModel) {
    val nome by cadastroScreenViewModel.nome.observeAsState(initial = "")
    val sobrenome by cadastroScreenViewModel.sobrenome.observeAsState(initial = "")
    val email by cadastroScreenViewModel.email.observeAsState(initial = "")
    val senha by cadastroScreenViewModel.senha.observeAsState(initial = "")
    val nrtelefone by cadastroScreenViewModel.nrtelefone.observeAsState(initial = "")
    var inputText by remember { mutableStateOf(nrtelefone.toString()) }

    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    Fundo(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BotaoVoltar(
                modifier = Modifier.align(Alignment.Start),
                onclick = {
                    navController.navigate("entrar")
                }
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Criar sua conta",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    fontSize = 32.sp,
                    color = (colorResource(id = R.color.cinzaescuro)),
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            CaixaDeEntrada(
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
                placeholder = "E-mail",
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
            Spacer(modifier = Modifier.height(32.dp))
            Botao(
                modifier = Modifier
                    .padding(4.dp),
                onclick = {
                    contaRepository.salvarConta(cadastroScreenViewModel.cadastrarContaViewModel())
                    navController.navigate("entrar")
                },
                text = "Cadastrar"
            )
        }
    }
}