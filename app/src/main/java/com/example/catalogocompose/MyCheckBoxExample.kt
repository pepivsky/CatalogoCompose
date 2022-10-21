package com.example.catalogocompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



data class CheckInfo(val title: String, var selected: Boolean = false, var onCheckedChange: (Boolean) -> Unit)


// regresa una lista de objetos chekInfo que se usan para la funcionalidad de los checkbox
@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map { title ->
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = title,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }
}

// crea un solo checkbox con texto
@Composable
fun MyCheckBoxCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = checkInfo.title)
    }
}


// CheckBox simple
@Preview
@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state, onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

// checkbox con texto
@Preview
@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Ejemplo check con texto")
    }
}

//CheckBox con 3 estados(true, false, indeterminado)
@Composable
fun MyTriStatusCheckBox() {
    // estado mutable
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when(status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}