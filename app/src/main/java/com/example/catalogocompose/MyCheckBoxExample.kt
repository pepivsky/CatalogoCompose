package com.example.catalogocompose

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )

}