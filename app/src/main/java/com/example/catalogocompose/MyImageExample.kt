package com.example.catalogocompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "imagen de ejemplo",
        alpha = 0.4F
    )
}

@Preview(showBackground = true)
@Composable
fun MyImageAdvanced() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "imagen de ejemplo",
        alpha = 0.4F,
        modifier = Modifier
            .height(
                300.dp
            )
            .width(300.dp)
            .clip(RoundedCornerShape(25f))
    )
}

@Preview(showBackground = true)
@Composable
fun MyCircleImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "imagen de ejemplo",
        modifier = Modifier
            .height(
                300.dp
            )
            .width(300.dp)
            .clip(CircleShape)
            .border(5.dp, Color.Blue, CircleShape)
    )
}

@Preview()
@Composable
fun MyIcon() {
    Icon(
        modifier = Modifier.background(Color.Yellow).clip(CircleShape),
        imageVector = Icons.Rounded.Star,
        contentDescription = "Star icon",
        tint = Color.Green

    )
}