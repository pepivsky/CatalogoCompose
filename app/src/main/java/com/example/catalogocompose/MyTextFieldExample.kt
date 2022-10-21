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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("Pepe") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = { myText = it })
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextFieldAdvanced() {
    var myText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        Modifier.padding(20.dp),
        label = { Text(text = "Introduce tu nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Blue)

    )
}