package com.example.catalogocompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Ejemplo simple de recyclerView
@Preview(showBackground = true)
@Composable
fun MyRecycler() {
    val names = listOf("Pepe", "Aris", "Manolo")

    LazyColumn {
        // primer item
        item { Text(text = "Header") }

        // se le puede pasar una lista o un array
        items(names) {
            Text(text = "My name is $it")
        }

        // ultimo item, distinto a los otros
        item {
            Row() {
                Text(text = "Footer")
                Image(modifier = Modifier.size(20.dp),painter = painterResource(id = R.drawable.elon), contentDescription = "Elon")
            }
        }

    }

}

