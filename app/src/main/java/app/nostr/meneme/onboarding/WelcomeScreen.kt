package app.nostr.meneme.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.nostr.meneme.R
import app.nostr.meneme.ui.theme.MenemeTheme

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onNewProfile: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

//    val screenHeight = LocalWindowInfo.current.containerSize.height.dp

    Surface (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "emeneme",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.fingerprint_color),
                contentDescription = "Fingerprint logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(screenHeight * 0.4f)
                    .aspectRatio(0.5f),
            )

            Spacer(Modifier.height(32.dp))

            Text(
                text = "Reclaim your digital self",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Your data, your way.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.weight(1f))


            // Primary action — FilledButton, 56dp height, 16dp radius
            Button(
                onClick = {
                    onNewProfile()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large, // large ≈ 16dp by default in M3
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 1.dp)
            ) {
                Text(
                    text = "Create new identity",
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                )
            }

            Spacer(Modifier.height(16.dp))

            // Secondary action — OutlinedButton
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Restore identity",
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun WelcomeScreenPreview(modifier: Modifier = Modifier) {
    MenemeTheme {
        WelcomeScreen(modifier, {})
    }
}