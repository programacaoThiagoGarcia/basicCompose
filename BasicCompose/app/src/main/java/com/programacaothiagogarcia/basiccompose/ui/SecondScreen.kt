package com.programacaothiagogarcia.basiccompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programacaothiagogarcia.basiccompose.ui.theme.BasicComposeTheme


@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onContinueClicked: ()-> Unit) {

    BasicComposeTheme {
        OnBoardingElement {
            onContinueClicked()
        }
    }
}

@Composable
fun OnBoardingElement(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = "Welcome to the Basics Codelab!")
        ElevatedButton(modifier = Modifier.padding(24.dp), onClick = {
            onClick()
        }) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingScreenPreView() {
    OnBoardingScreen{
        
    }
}
