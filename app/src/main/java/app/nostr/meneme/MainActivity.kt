package app.nostr.meneme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.nostr.meneme.dashboard.DashboardScreen
import app.nostr.meneme.ui.theme.MenemeTheme
import app.nostr.meneme.onboarding.WelcomeScreen
import com.vitorpamplona.quartz.crypto.KeyPair

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                        WelcomeScreen(onNewProfile = {
                            KeyPair()
                            navigation.navigate("dashboard")
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
