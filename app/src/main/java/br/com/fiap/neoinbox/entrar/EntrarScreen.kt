package br.com.fiap.neoinbox.entrar

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Link
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreen
import br.com.fiap.neoinbox.ui.theme.Inter

@Composable
fun EntrarScreen(navController: NavController, entrarScreenViewModel: EntrarScreenViewModel) {

    val email by entrarScreenViewModel.email.observeAsState(initial = "")
    val senha by entrarScreenViewModel.senha.observeAsState(initial = "")

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.azulclaro)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Inserir logo
            Spacer(modifier = Modifier.height(32.dp))
            CaixaDeEntrada(
                label = "Digite o seu endereço de Email",
                placeholder = "Endereço de Email",
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
                label = "Digite a sua senha",
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
            Button(
                modifier = Modifier
                    .padding(4.dp),
                onClick = {
                    if(entrarScreenViewModel.entrarNaContaViewModel()) navController.navigate("EntradaScreen")
                },
            ) {
                Text(text = "Entrar")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Link(
                onclick = {navController.navigate("recuperarSenha")},
                text = "Esqueceu sua senha",
                modifier = Modifier
                    .padding(4.dp),
                fontfamily = Inter,
                fontsize = 16,
                textcolor = colorResource(id = R.color.cinzaescuro),
                textalign = TextAlign.Center,
            )
            Link(
                text = "Não possui uma conta? Cadastre-se",
                modifier = Modifier
                    .padding(4.dp),
                fontfamily = Inter,
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
                    fontfamily = Inter,
                    fontsize = 14,
                    textcolor = colorResource(id = R.color.cinzaescuro),
                    textalign = TextAlign.Center,
                    onclick = null
                )
                Link(
                    modifier = Modifier.size(width = 150.dp, height = 80.dp),
                    text = "Políticas de Privacidade",
                    fontfamily = Inter,
                    fontsize = 14,
                    textcolor = colorResource(id = R.color.cinzaescuro),
                    textalign = TextAlign.Center,
                    onclick = null
                )
            }
        }
    }

}

