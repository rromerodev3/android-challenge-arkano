package com.roy.rromeroarkanochallenge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roy.rromeroarkanochallenge.presentation.theme.RRomeroChallengeArkanoTheme
import com.roy.rromeroarkanochallenge.presentation.ui.character.CharacterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RRomeroChallengeArkanoTheme() {
                CharacterScreen()
            }
        }
    }
}