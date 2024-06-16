package br.com.fiap.neoinbox.entrar

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.Link
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreen
import br.com.fiap.neoinbox.ui.theme.Inter

@Composable
fun EntrarScreen(entrarScreenViewModel: EntrarScreenViewModel) {

    val email by entrarScreenViewModel.email.observeAsState(initial = "")
    val senha by entrarScreenViewModel.senha.observeAsState(initial = "")

//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = "entrar",
//        exitTransition = {
//            slideOutOfContainer(
//                towards =
//                AnimatedContentTransitionScope.SlideDirection.End,
//                animationSpec = tween(1000)
//            ) + fadeOut(animationSpec = tween((1000)))
//        },
//        enterTransition = {
//            slideIntoContainer(towards =
//            AnimatedContentTransitionScope.SlideDirection.Start,
//                animationSpec = tween(3000)
//            )
//        }
//    ) {
//        composable(route = "entrar") { EntrarScreen(navController) }
//        composable(route = "recuperarSenha") { RecuperarSenhaScreen(navController) }
//
//    }

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                onClick = {

                    entrarScreenViewModel.entrarNaContaJurosViewModel()
                },
            ) {
                Text(text = "Entrar")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Link(
                onclick = "recuperarSenha",
                text = "Esqueceu sua senha",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                fontfamily = Inter,
                fontsize = 16
            )
            Link(
                text = "Não possui uma conta? Cadastre-se",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                fontfamily = Inter,
                fontsize = 16,
                onclick = ""
            )
        }
    }

}

@Preview
@Composable
private fun EntrarScreenPreview() {
    EntrarScreen(EntrarScreenViewModel())
}