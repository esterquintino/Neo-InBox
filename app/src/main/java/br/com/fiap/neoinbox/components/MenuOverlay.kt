package br.com.fiap.neoinbox.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.neoinbox.R

@Composable
fun MenuOverlay(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(colorResource(id = R.color.cinzaescuro)),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.cinzaescuro))
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ){
                Text(
                    text = "Tipo de conta",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "endereço de email",
                    modifier = Modifier
                        .clickable { onDismiss() }
                        .fillMaxWidth()
                )
            }

        }
    }
}

@Preview
@Composable
private fun MenuOverlayPreview() {
    MenuOverlay{
//        exibirMenu = false
    }

}