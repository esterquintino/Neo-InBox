package br.com.fiap.neoinbox.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.neoinbox.R
import androidx.compose.ui.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(
    placeholder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    atualizarValor: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = atualizarValor,
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(
                colorResource(id = R.color.branco_80)
            ),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            color = (colorResource(id = R.color.cinzaescuro))
        ),
        colors =  TextFieldDefaults.outlinedTextFieldColors (
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = (colorResource(id = R.color.azulclaro)),
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontSize = 16.sp,
                    color = (colorResource(id = R.color.cinzaescuro))
                )
            )
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}