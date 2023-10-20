package com.programacaothiagogarcia.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programacaothiagogarcia.basiccompose.ui.theme.BasicComposeTheme

/*

 https://developer.android.com/jetpack/compose/modifiers-list?hl=pt-br
 List de Modificadores

 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                MyApp()
            }
        }
    }
}


@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Linha 0", "Linha 1", "Linha 2")
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        names.forEach { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expand = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expand.value) 48.0.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp), verticalAlignment = Alignment.Top) {
            Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(text = "Número da linha")
                Text(text = name)
            }
            ElevatedButton(
                onClick = {
                    expand.value = !expand.value
                }, modifier = Modifier
            ) {
                val text = if (expand.value) "Show Less" else "Show More"
                Text(text = text)
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    MyApp()
}


