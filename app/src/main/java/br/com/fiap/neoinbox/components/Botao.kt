package br.com.fiap.neoinbox.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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