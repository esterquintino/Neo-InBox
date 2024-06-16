package br.com.fiap.neoinbox.entrar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Link
import br.com.fiap.neoinbox.ui.theme.Inter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import br.com.fiap.neoinbox.components.Botao
import br.com.fiap.neoinbox.components.Fundo
import br.com.fiap.neoinbox.database.repository.ContaRepository

@Composable
fun EntrarScreen(navController: NavController, entrarScreenViewModel: EntrarScreenViewModel) {

    val email by entrarScreenViewModel.email.observeAsState(initial = "")
    val senha by entrarScreenViewModel.senha.observeAsState(initial = "")

    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    Fundo(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.icon_message),
                contentDescription = "ícone de envelope com uma página de site",
                modifier = Modifier
                    .size(64.dp)
            )
            Text(
                text = "NeoInBox",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inria_sans_bold)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = (colorResource(id = R.color.black))
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            CaixaDeEntrada(
                    placeholder = "E-mail",
                value = email,
                keyboardType = KeyboardType.Email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                atualizarValor = {
                    entrarScreenViewModel.onEmailChanged(it)
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
                    entrarScreenViewModel.onSenhaChanged(it)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Botao(
                modifier = Modifier,
                onclick = {
                    val (email, senha) = entrarScreenViewModel.entrarNaContaViewModel()
                    val entrarCheck = contaRepository.entrarNaConta(email, senha)
                    if(entrarCheck > 0) navController.navigate("EntradaScreen")
                },
                text = "Entrar"
            )
            Spacer(modifier = Modifier.height(32.dp))
            Link(
                onclick = {navController.navigate("recuperarSenha")},
                text = "Esqueceu sua senha?",
                modifier = Modifier
                    .padding(4.dp),
                fontfamily = FontFamily(Font(R.font.inter_medium)) ,
                fontsize = 16,
                textcolor = colorResource(id = R.color.cinzaescuro),
                textalign = TextAlign.Center,
            )
            Link(
                text = "Não possui uma conta? Cadastre-se",
                modifier = Modifier
                    .padding(4.dp),
                fontfamily = FontFamily(Font(R.font.inter_medium)),
                fontsize = 16,
                textcolor = colorResource(id = R.color.cinzaescuro),
                textalign = TextAlign.Center,
                onclick = {navController.navigate("cadastro")}
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Link(
                    modifier = Modifier.size(width = 150.dp, height = 80.dp),
                    text = "Termos de Uso",
                    fontfamily = FontFamily(Font(R.font.inter_medium)),
                    fontsize = 14,
                    textcolor = colorResource(id = R.color.cinzaescuro),
                    textalign = TextAlign.Center,
                    onclick = null
                )
                Link(
                    modifier = Modifier.size(width = 150.dp, height = 80.dp),
                    text = "Políticas de Privacidade",
                    fontfamily = FontFamily(Font(R.font.inter_medium)),
                    fontsize = 14,
                    textcolor = colorResource(id = R.color.cinzaescuro),
                    textalign = TextAlign.Center,
                    onclick = null
                )
            }
        }
    }

}

