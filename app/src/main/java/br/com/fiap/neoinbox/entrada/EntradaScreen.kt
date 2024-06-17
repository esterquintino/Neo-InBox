package br.com.fiap.neoinbox.entrada

import androidx.annotation.ContentView
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.components.Botao
import br.com.fiap.neoinbox.components.BotaoMenu
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.EmailCard
import br.com.fiap.neoinbox.components.IconeUsuario

@Composable
fun EntradaScreen(navController: NavController, entradaScreenViewModel: EntradaScreenViewModel) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.areia)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            ){
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ){
                BotaoMenu()
                // inserir imagem perfil
                IconeUsuario(
                    modifier = Modifier,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ){
                Text(
                    text = "Caixa de entrada",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_semibold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = (colorResource(id = R.color.cinzaescuro))
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                // Barra de pesquisa
                CaixaDeEntrada(
                    placeholder = "Busca",
                    value = "",
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(235.dp)
                        .height(50.dp),
                    atualizarValor = {
                    }
                )
                // Botão de filtros
                Botao(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(55.dp),
                    onclick = {
                    },
                    text = "Filtros"
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                for (i in 0..10){
                    EmailCard(){

                    }

                }
            }
        }
    }
}