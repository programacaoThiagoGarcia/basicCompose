package com.otw.android.estadojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otw.android.estadojetpackcompose.ui.theme.EstadoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadoJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }

    @Composable
    private fun WellnessScreen(modifier: Modifier = Modifier) {
        WaterCounter()
    }

    @Composable
    private fun WaterCounter(modifier: Modifier = Modifier) {
        var count = 0
        Column {
            Text(
                text = "You've had $count glasses.",
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            ElevatedButton(onClick = { count++ }) {
                Text("Add one", color = MaterialTheme.colorScheme.tertiary)
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    private fun WellnessScreenPreview() {
        this.WellnessScreen()
    }
}





