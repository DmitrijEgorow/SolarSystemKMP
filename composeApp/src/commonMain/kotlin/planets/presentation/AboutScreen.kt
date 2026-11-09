package planets.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.stringResource
// Импорты ресурсов (если красные - нажми Alt+Enter)
import solarsystem.composeapp.generated.resources.Res
import solarsystem.composeapp.generated.resources.about_app
import solarsystem.composeapp.generated.resources.developer
import solarsystem.composeapp.generated.resources.version

@Composable
fun AboutScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.about_app),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(Res.string.version),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(Res.string.developer),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onBack) {
            Text("Назад") // Пока оставим так, потом добавим в ресурсы
        }
    }
}