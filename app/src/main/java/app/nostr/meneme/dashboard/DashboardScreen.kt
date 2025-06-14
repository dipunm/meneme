package app.nostr.meneme.dashboard

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.nostr.meneme.ui.theme.MenemeTheme

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
    ) {
        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
        ) {
            Card (
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(
                        min = 150.dp,
                    )
                ,
            ){
                Text(
//                    modifier = Modifier.background(Color.Red),
                    modifier = Modifier.padding(all = 16.dp),
                    text = "HELLO WORLD!!",
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun DashboardScreenPreview(modifier: Modifier = Modifier) {
    MenemeTheme {
        DashboardScreen(modifier)
    }
}