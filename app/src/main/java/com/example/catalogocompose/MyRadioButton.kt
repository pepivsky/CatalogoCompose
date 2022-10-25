package com.example.catalogocompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyRadioButton() {

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = true, onClick = { }, colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            unselectedColor = Color.Yellow,
            disabledColor = Color.Green
        ))
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Ejemplo 1 radiobutton")
    }
}


// Lista de radioButtons que permite seleccionar solo uno a la vez
@Preview
@Composable
fun MyRadioButtonList() {
    var selected by rememberSaveable {
        mutableStateOf("Aris")
    }

    Column(Modifier.fillMaxWidth()) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Aris", onClick = { selected = "Aris" })
            Text(text = "Aris")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Pepe", onClick = { selected = "Pepe" })
            Text(text = "Pepe")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Brais", onClick = { selected = "Brais" })
            Text(text = "Brais")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Nico", onClick = { selected = "Nico" })
            Text(text = "Nico")
        }
    }
}

// state hoisting
//@Preview
@Composable
fun MyRadioButtonListStateHoisting(name: String, onItemSelected: (String) -> Unit) {
    /*var selected by rememberSaveable {
        mutableStateOf("Aris")
    }*/

    Column(Modifier.fillMaxWidth()) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Aris", onClick = { onItemSelected("Aris") })
            Text(text = "Aris")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Pepe", onClick = { onItemSelected("Pepe") })
            Text(text = "Pepe")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Brais", onClick = { onItemSelected("Brais") })
            Text(text = "Brais")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Nico", onClick = { onItemSelected("Nico") })
            Text(text = "Nico")
        }
    }
}

