package app.nostr.meneme.onboarding

import androidx.lifecycle.ViewModel
import com.vitorpamplona.quartz.crypto.KeyPair

class WelcomeScreenViewModel(private val onAccountCreated: () -> Unit) : ViewModel() {
    fun createNewAccount() {
        val keyPair = KeyPair()


        onAccountCreated()
    }

    fun restoreAccount() {

    }
}