package com.otw.android.estadojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otw.android.estadojetpackcompose.ui.WellnessTasksList
import com.otw.android.estadojetpackcompose.ui.getWellnessTasks
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
        var count by rememberSaveable {
            mutableStateOf(0)
        }

        Column {
            if (count > 0) {
                /* Show task é apenas feito o reset (true) quando chamamos o botão reset e a variável count é colocada como 0, assim uma nova
                 composição é criada e nesta nova composição a variável showTask é novamente iniciada, porque está no bloco não foi feito remeber

               https://developer.android.com/codelabs/jetpack-compose-state?hl=pt_br#6
                * */

                var showTask by rememberSaveable {
                    mutableStateOf(true)
                }
                Text(
                    text = "You've had $count glasses.",
                    modifier = modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                if (showTask) {
                    val list = remember {
                        getWellnessTasks().toMutableStateList()
                    }
                    WellnessTasksList(list = list,onCloseTask = {task -> list.remove(task)})
                }
            }
            Row {
                ElevatedButton(
                    onClick = { count++ },
                    modifier = Modifier.padding(8.dp),
                    enabled = count < 10
                ) {
                    Text("Add one", color = MaterialTheme.colorScheme.tertiary)
                }
                if (count > 0) {
                    ElevatedButton(onClick = { count = 0 }, modifier = Modifier.padding(8.dp)) {
                        Text("Reset", color = MaterialTheme.colorScheme.tertiary)
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun WellnessScreenPreview() {
        this.WellnessScreen()
    }
}





