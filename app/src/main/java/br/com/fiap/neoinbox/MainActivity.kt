package br.com.fiap.neoinbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.neoinbox.entrar.EntrarScreen
import br.com.fiap.neoinbox.entrar.EntrarScreenViewModel
import br.com.fiap.neoinbox.ui.theme.NeoInboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeoInboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EntrarScreen(EntrarScreenViewModel())
                }
            }
        }
    }
}

@Composable
fun Loading() {
   Column {
       Row {
           Text(
               text = "Hello User!",
           )
       }
       Row {
           Button(onClick = { /*TODO*/ } ) {
               Text(text = "Seguir ->")
           }
       }
   }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    NeoInboxTheme {
        Loading()
    }
}