package com.ainews.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ainews.app.ui.AIHealthNewsNavHost
import com.ainews.app.ui.theme.AIHealthNewsTheme

/**
 * Main activity for the AI Health News app.
 * 
 * This app provides a daily feed of health news articles with AI-powered features:
 * - Screen 1: Load mock health news articles
 * - Screen 2: AI-generated TL;DR summaries and 3 key takeaways for each article
 * - Screen 3: Paginated feed with pull-to-refresh functionality
 * - Screen 4: Expanded article view with AI-simplified content in a friendly tone
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AIHealthNewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AIHealthNewsNavHost()
                }
            }
        }
    }
}
