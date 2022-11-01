package com.example.catalogocompose

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogocompose.model.SuperHero
import kotlinx.coroutines.launch


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
// recyclerView normal
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

// recyclerView ncon cabecera
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    // agrupar por publisher
    val superHero = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHero.forEach { (publisher, mySuperHero) ->

            // cabecera agrupada por publisher, la cabecera es un texto
            stickyHeader {
                Text(modifier = Modifier.background(Color.Cyan).fillMaxWidth(),text = publisher)
            }

            // pasarle los items
            items(mySuperHero) { hero ->
                ItemHero(hero) { Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show() }
            }
        }


    }
}

// recyclerview Grid
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(getSuperHeroes()) { hero ->
            ItemHero(hero) { Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show() }
        }
    }, contentPadding = PaddingValues(all = 16.dp))

}

// recyclerView control especial
@Preview(showBackground = true)
@Composable
fun SuperHeroViewWithSpecialControl() {
    val context = LocalContext.current
    val rvState = rememberLazyListState() // estado del recycler
    val coroutineScope = rememberCoroutineScope() // scope para usar corutinas

    Column {
        LazyColumn(modifier = Modifier.weight(1F),state = rvState, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(getSuperHeroes()) { hero ->
                ItemHero(hero) { Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show() }
            }
        }

        // estado intermedio optimizado para no redibujar la ui cada vez que se le hace scroll al rv
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        // si el item que vemos la hacer scroll es > 0 entonces se muestra el boton
        if (showButton) {
            Button(modifier = Modifier.align(Alignment.CenterHorizontally),onClick = {
                // nos lleva al item indicado, debe ser ejecutado en una corutina
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Soy un boton cool")
            }
        }

    }
}

// item para dibujar cada superhero y controlar el tap en el item
@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemSelected(superHero) }, border = BorderStroke(2.dp, Color.Red)) {
        Column(){
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = superHero.photo),
                contentDescription = "hero avatar",
                contentScale = ContentScale.Crop
            )
            Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = superHero.superheroName)
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),text = superHero.realName)
            Text(modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp),text = superHero.publisher)

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
