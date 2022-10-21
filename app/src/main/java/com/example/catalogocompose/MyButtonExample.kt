package com.example.catalogocompose

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Preview(showBackground = true)
@Composable
fun MyButton() {
    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, color = Color.Green),
            enabled = enable,
            onClick = {
                Log.i("Ejemplo", "Esto es un ejemplo")
                enable = false
            }

        ) {
            Text(text = "Hola")
        }

        
        OutlinedButton(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.Yellow,
                disabledBackgroundColor =  Color.Magenta,
                disabledContentColor = Color.Blue

            ),
            enabled = enable,
            onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
        
        
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Holita")
        }

    }
}