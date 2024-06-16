package br.com.fiap.neoinbox.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Botao(
    modifier: Modifier,
    onclick: () -> Unit
){
    Button(
        modifier = modifier,
        onClick = onclick
    ) {

    }
}