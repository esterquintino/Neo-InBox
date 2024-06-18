package br.com.fiap.neoinbox.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.neoinbox.LocalUserPreferences
import br.com.fiap.neoinbox.R
import br.com.fiap.neoinbox.database.repository.ContaRepository

@Composable
fun MenuOverlay(navController: NavController, onDismiss: () -> Unit) {


    val userPreferences = LocalUserPreferences.current
    val context = LocalContext.current
    val contaRepository = ContaRepository(context)

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(Color(0xFF2F2F2F)),
        contentAlignment = Alignment.TopStart
    ) {
        // Coluna geral
        Column(
            modifier = Modifier
                .background(Color(0xFF2F2F2F))
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            // Row de perfil e opções
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(modifier = Modifier.width(150.dp)) {
                    Text(
                        text = "Tipo de conta",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_semibold)),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Endereço de e-mail",
                        modifier = Modifier
                            .clickable { onDismiss() }
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                        )
                    )
                }
                Column() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_user_profile),
                        contentDescription = "Perfil de usuário",
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable { onDismiss() }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Caixa de entrada",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                            navController.navigate("entrada") }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Favoritos",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Rascunhos",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Spam",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Lixeira",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Pastas",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Calendário",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                            navController.navigate("calendario")
                        }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Configurações",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Sair da conta",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                            navController.navigate("entrar")
                        }
                        .fillMaxWidth()
                        .background(Color(0xFF2F2F2F))
                        .padding(10.dp),
                    color = Color.White
                )
            }
        }
    }
}
