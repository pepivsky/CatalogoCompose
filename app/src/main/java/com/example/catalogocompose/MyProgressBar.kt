package com.example.catalogocompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Preview(showBackground = true)
@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false)}

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {

            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                backgroundColor = Color.Yellow
            )
        }

        Button(modifier = Modifier.padding(top = 16.dp),onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyProgressAndvanced() {

    var progress by rememberSaveable { mutableStateOf(0.0F)}

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { if (progress < 1.0F) { progress+= 0.1F }  }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { if (progress > 0.1) { progress -= 0.1F } }) {
                Text(text = "Reducir")
            }
        }
    }
}