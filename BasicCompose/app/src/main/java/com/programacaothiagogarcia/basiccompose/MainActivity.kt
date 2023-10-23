package com.programacaothiagogarcia.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programacaothiagogarcia.basiccompose.ui.OnBoardingElement
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
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOnboarding by rememberSaveable {
        mutableStateOf(true)
    }
    Surface {
        if (shouldShowOnboarding) {
            OnBoardingElement(modifier) {
                shouldShowOnboarding = false
            }
        } else {
            Greetings()
        }
    }

}

@Composable
private fun Greetings(names: List<String> = listOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16")) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        this.items(items = names) {
            Greeting(name = it)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expand = rememberSaveable {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(if (expand.value) 48.0.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "",
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp), verticalAlignment = Alignment.Top) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
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

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    MyApp(modifier = Modifier.fillMaxSize())
}




