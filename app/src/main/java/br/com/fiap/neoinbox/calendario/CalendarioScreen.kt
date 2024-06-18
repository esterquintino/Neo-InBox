package br.com.fiap.neoinbox.calendario

import android.annotation.SuppressLint
import android.widget.CalendarView
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.fiap.neoinbox.R
import java.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import br.com.fiap.neoinbox.cadastro.CadastroScreenViewModel
import br.com.fiap.neoinbox.components.Botao
import br.com.fiap.neoinbox.components.BotaoMenu
import br.com.fiap.neoinbox.components.CaixaDeEntrada
import br.com.fiap.neoinbox.components.EmailCard
import br.com.fiap.neoinbox.components.EmailContent
import br.com.fiap.neoinbox.components.IconeUsuario
import java.util.Date

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarioScreen(
    navController: NavController,
    calendarioScreenViewModel: CalendarioScreenViewModel
) {
    var date by remember { mutableStateOf("") }

    // Pega o dia atual
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH)
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)


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
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "Calendário",
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
                AndroidView(factory = { CalendarView(it) }, update = {
                    it.date = calendar.timeInMillis
                    it.setOnDateChangeListener { calendarView, year, month, day ->
                        date = "$day - ${month + 1} - $year"
                    }
                })
                Text(text = date)
            }
            Row (
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top
            ){
                Botao(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(55.dp)
                        .width(200.dp),
                    onclick = {

                    },
                    text = "Adicionar evento"
                )
            }
        }
    }

}

//Column(
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally,
//modifier = Modifier.fillMaxSize()
//) {
//    AndroidView(factory = { CalendarView(it) }, update = {
//        it.date = calendar.timeInMillis
//        it.setOnDateChangeListener { calendarView, year, month, day ->
//            date = "$day - ${month + 1} - $year"
//        }
//    })
//    Text(text = date)
//}

//@Preview
//@Composable
//private fun CalendarioScreenPreview() {
//    CalendarioScreen( calendarioScreenViewModel = CalendarioScreenViewModel())
//}
