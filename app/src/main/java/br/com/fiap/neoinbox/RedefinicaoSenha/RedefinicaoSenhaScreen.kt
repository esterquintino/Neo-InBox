package br.com.fiap.neoinbox.RedefinicaoSenha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.Botao
import br.com.fiap.neoinbox.components.BotaoVoltar
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Fundo
import br.com.fiap.neoinbox.database.repository.ContaRepository

@Composable
fun RedefinicaoSenhaScreen(navController: NavController, redefinicaoSenhaScreenViewModel: RedefinicaoSenhaScreenViewModel, email: String?) {

    val novaSenha by redefinicaoSenhaScreenViewModel.novaSenha.observeAsState(initial = "")

    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    Fundo(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotaoVoltar(
                modifier = Modifier
                    .align(Alignment.Start),
                onclick = {
                    navController.navigate("entrar")
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Redefinir Senha",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    fontSize = 28.sp,
                    color = (colorResource(id = R.color.cinzaescuro)),
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            CaixaDeEntrada(
                placeholder = "Código recebido",
                value = "",
                keyboardType = KeyboardType.Number,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                atualizarValor = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CaixaDeEntrada(
                placeholder = "Nova senha",
                value = novaSenha,
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                atualizarValor = {
                    redefinicaoSenhaScreenViewModel.onNovaSenhaChanged(it)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Botao(
                modifier = Modifier
                    .padding(4.dp),
                onclick = {
                    contaRepository.redefinicaoSenha(redefinicaoSenhaScreenViewModel.redefinicaoSenhaScreenViewModel(email!!))
                    navController.navigate("entrar")
                },
                text = "Confirmar"
            )
        }
    }
}