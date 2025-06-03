package app.nostr.meneme

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.nostr.meneme.dashboard.DashboardScreen
import app.nostr.meneme.ui.theme.MenemeTheme
import app.nostr.meneme.welcome.WelcomeScreen
import com.vitorpamplona.quartz.crypto.KeyPair
import com.vitorpamplona.quartz.encoders.toHexKey
import com.vitorpamplona.quartz.encoders.toNpub
import javax.crypto.SecretKey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var keypair = remember { mutableStateOf<KeyPair?>(null) }
            val navigation = rememberNavController()
            MenemeTheme {
                NavHost(
                    modifier = Modifier.fillMaxSize(),
                    navController = navigation,
                    startDestination = "welcome",
                    enterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { fullWidth -> fullWidth } // Slide in from right
                        ) + fadeIn()
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { fullWidth -> -fullWidth } // Slide out to left
                        ) + fadeOut()
                    },
                    popEnterTransition = { // Optional: Customize pop enter transition
                        slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn()
                    },
                    popExitTransition = { // Optional: Customize pop exit transition
                        slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut()
                    }
                ) {
                    composable("dashboard") { DashboardScreen() }
                    composable("welcome") {
//                        val kp = keypair.value;
//                        if (kp != null) {
//                            Text(
//                                modifier = Modifier.fillMaxWidth(),
//                                text = kp.pubKey.toNpub()
//                            )
//                        }
                        WelcomeScreen(onNewProfile = {
                            keypair.value = KeyPair()
    //                        navigation.navigate("dashboard")
                        })
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MainPreview() {
    MenemeTheme {
        WelcomeScreen(onNewProfile = { })
    }
}
