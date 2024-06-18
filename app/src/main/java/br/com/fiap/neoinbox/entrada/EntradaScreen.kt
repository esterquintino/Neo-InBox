package br.com.fiap.neoinbox.entrada

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
import br.com.fiap.neoinbox.components.EmailContent
import br.com.fiap.neoinbox.components.IconeUsuario

@Composable
fun EntradaScreen(navController: NavController, entradaScreenViewModel: EntradaScreenViewModel) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.areia)),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                BotaoMenu(navController)
                Spacer(modifier = Modifier.weight(1f))
                IconeUsuario(
                    modifier = Modifier,
                    onclick = {
                        navController.navigate("conta")
                    }
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
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
                CaixaDeEntrada(
                    placeholder = "Busca",
                    value = "",
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(230.dp)
                        .height(50.dp),
                    atualizarValor = {
                    }
                )
                Botao(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(55.dp),
                    onclick = {
                    },
                    text = "Filtros"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                EmailCard(
                    modifier = Modifier.padding(16.dp)
                ) {
                    EmailContent(
                        sender = "Remetente",
                        subject = "Assunto do email",
                        preview = "Corpo do email"
                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                EmailCard(
                    modifier = Modifier.padding(16.dp)
                ) {
                    EmailContent(
                        sender = "Remetente",
                        subject = "Assunto do email",
                        preview = "Corpo do email"
                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                EmailCard(
                    modifier = Modifier.padding(16.dp)
                ) {
                    EmailContent(
                        sender = "Remetente",
                        subject = "Assunto do email",
                        preview = "Corpo do email"
                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                //lógica de listagem de emails
                EmailCard(
                    modifier = Modifier.padding(16.dp)
                ) {
                    EmailContent(
                        sender = "Remetente",
                        subject = "Assunto do email",
                        preview = "Corpo do email"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {
                //lógica botão escrever email
            }
        }
    }
}