package com.example.catalogocompose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogocompose.model.SuperHero

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
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.elon),
                    contentDescription = "Elon"
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { hero ->
            ItemHero(hero) { Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show() }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(modifier = Modifier.width(200.dp).clickable { onItemSelected(superHero) }, border = BorderStroke(2.dp, Color.Red)) {
        Column(){
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = superHero.photo),
                contentDescription = "hero avatar",
                contentScale = ContentScale.Crop
            )
            Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = superHero.superheroName)
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),text = superHero.realName)
            Text(modifier = Modifier.align(Alignment.End).padding(8.dp),text = superHero.publisher)

        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce", "DC", R.drawable.batman),
        SuperHero("Daredevil", "n/a", "DC", R.drawable.daredevil),
        SuperHero("Flash", "Jay", "DC", R.drawable.flash),
        SuperHero("Green Latern", "n/a", "DC", R.drawable.green_lantern),
        SuperHero("Thor", "Thor", "Marvel", R.drawable.thor),
        SuperHero("Wonder Woman", "n/a", "DC", R.drawable.wonder_woman),
    )
}
