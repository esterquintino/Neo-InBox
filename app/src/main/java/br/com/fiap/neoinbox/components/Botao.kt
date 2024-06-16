package br.com.fiap.neoinbox.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.neoinbox.R

@Composable
fun Botao(
    modifier: Modifier,
    onclick: () -> Unit,
    text: String
){
    Button(
        modifier = modifier
            .padding(4.dp)
            .width(150.dp)
            .height(50.dp),
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.cinzaescuro)
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.white)
            )
        )
    }
}