package br.com.fiap.neoinbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.neoinbox.cadastro.CadastroScreen
import br.com.fiap.neoinbox.cadastro.CadastroScreenViewModel
import br.com.fiap.neoinbox.entrada.EntradaScreen
import br.com.fiap.neoinbox.entrada.EntradaScreenViewModel
import br.com.fiap.neoinbox.entrar.EntrarScreen
import br.com.fiap.neoinbox.entrar.EntrarScreenViewModel
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreen
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreenViewModel
import br.com.fiap.neoinbox.RedefinicaoSenha.RedefinicaoSenhaScreen
import br.com.fiap.neoinbox.ui.theme.NeoInboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeoInboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "entrar"
    ) {
        composable("entrar") {
            EntrarScreen(navController = navController, entrarScreenViewModel = EntrarScreenViewModel())
        }
        composable("recuperarSenha") {
            RecuperarSenhaScreen(navController = navController, recuperarSenhaScreenViewModel = RecuperarSenhaScreenViewModel())
        }
        composable("redefinicaoSenha") {
            RedefinicaoSenhaScreen(navController = navController)
        }
        composable("cadastro") {
            CadastroScreen(navController = navController, cadastroScreenViewModel = CadastroScreenViewModel())
        }
        composable("entrada") {
            EntradaScreen(navController = navController, entradaScreenViewModel = EntradaScreenViewModel())
        }
        // Outras rotas
    }
}
