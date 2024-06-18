package br.com.fiap.neoinbox.contaUsuario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.BotaoVoltar
import br.com.fiap.neoinbox.components.Fundo

@Composable
fun ContaUsuarioScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.areia)),
        contentAlignment = Alignment.TopStart
    ) {
        Fundo(
            modifier = Modifier
                .background(colorResource(id = R.color.areia)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                BotaoVoltar(
                    modifier = Modifier
                        .align(Alignment.Start),
                    onclick = {
                        navController.navigate("entrada")
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.Top
                ){
                    Text(
                        text = "Conta",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_semibold)),
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = (colorResource(id = R.color.cinzaescuro))
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "ícone de usuário",
                    modifier = Modifier
                        .size(90.dp)
                )
            }
        }
    }
}