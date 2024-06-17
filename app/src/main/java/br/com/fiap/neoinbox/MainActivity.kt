package br.com.fiap.neoinbox

import UserPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.neoinbox.cadastro.CadastroScreen
import br.com.fiap.neoinbox.cadastro.CadastroScreenViewModel
import br.com.fiap.neoinbox.entrada.EntradaScreen
import br.com.fiap.neoinbox.entrada.EntradaScreenViewModel
import br.com.fiap.neoinbox.entrar.EntrarScreen
import br.com.fiap.neoinbox.entrar.EntrarScreenViewModel
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreen
import br.com.fiap.neoinbox.recuperarSenha.RecuperarSenhaScreenViewModel
import br.com.fiap.neoinbox.RedefinicaoSenha.RedefinicaoSenhaScreen
import br.com.fiap.neoinbox.RedefinicaoSenha.RedefinicaoSenhaScreenViewModel
import br.com.fiap.neoinbox.calendario.CalendarioScreen
import br.com.fiap.neoinbox.calendario.CalendarioScreenViewModel
import br.com.fiap.neoinbox.ui.theme.NeoInboxTheme

val LocalUserPreferences = staticCompositionLocalOf<UserPreferences> {
    error("UserPreferences not provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userPreferences = UserPreferences(applicationContext)
        setContent {
            NeoInboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompositionLocalProvider(LocalUserPreferences provides userPreferences) {
                        AppNavHost()
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavHost(){

    val navController = rememberNavController()
    val userPreferences = LocalUserPreferences.current

    NavHost(
        navController = navController,
        startDestination = "entrar"
    ) {
        composable("entrar") {
            EntrarScreen(navController = navController, entrarScreenViewModel = EntrarScreenViewModel(userPreferences))
        }
        composable("recuperarSenha") {
            RecuperarSenhaScreen(navController = navController, recuperarSenhaScreenViewModel = RecuperarSenhaScreenViewModel())
        }
        composable(
            "redefinicaoSenha/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val emailRecebido = backStackEntry.arguments?.getString("email")
            RedefinicaoSenhaScreen(navController = navController, redefinicaoSenhaScreenViewModel = RedefinicaoSenhaScreenViewModel(), email = emailRecebido)
        }
        composable("cadastro") {
            CadastroScreen(navController = navController, cadastroScreenViewModel = CadastroScreenViewModel())
        }
        composable("entrada") {
            EntradaScreen(navController = navController, entradaScreenViewModel = EntradaScreenViewModel(userPreferences))
        }
        composable("calendario") {
            CalendarioScreen(navController = navController, calendarioScreenViewModel = CalendarioScreenViewModel(userPreferences))
        }
        // Outras rotas
    }
}
