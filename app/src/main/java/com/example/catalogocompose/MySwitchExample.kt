package com.example.catalogocompose

import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Preview(showBackground = true)
@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,

            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1F,
            uncheckedTrackAlpha = 0.1F,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow
        ),
        onCheckedChange = { state = !state },
        enabled = false
    )
}