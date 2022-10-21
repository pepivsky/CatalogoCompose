package com.example.catalogocompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {

        Text("Esto es un ejemplo")
        Text("Esto es un ejemplo", color = Color.Blue)
        Text("Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text("Esto es un ejemplo", fontWeight = FontWeight.Light)

        // usando style, podemos crear un objeto style y englobar el estilo completo, color, fuente, tamano y aplicarlo mas facilmente pasando solo el textStyle
        Text(
            "Esto es un ejemplo",
            style = TextStyle(fontFamily = FontFamily.Cursive, color = Color.Red)
        )
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))


        // sin style
        Text("Esto es un ejemplo", fontFamily = FontFamily.Cursive, color = Color.Red)
        Text("Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text("Esto es un ejemplo", textDecoration = TextDecoration.Underline)

        // text con varios decorations
        Text(
            "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )

        Text("Esto es un ejemplo", fontSize = 30.sp)
    }
}


