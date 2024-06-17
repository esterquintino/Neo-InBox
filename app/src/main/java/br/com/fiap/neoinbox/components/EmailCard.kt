package br.com.fiap.neoinbox.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.neoinbox.R

@Composable
fun EmailCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.areia)
        )
    ) {
        content(
        )
    }
}

val senderTextStyle = TextStyle(
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
)

val subjectTextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    color = Color.DarkGray
)

val previewTextStyle = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    color = Color.LightGray
)

@Composable
fun EmailContent(sender: String, subject: String, preview: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = sender, style = senderTextStyle)
        Text(text = subject, style = subjectTextStyle)
        Text(text = preview, style = previewTextStyle)
        Spacer(modifier = Modifier.height(5.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}
