package com.example.catalogocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogocompose.ui.theme.CatalogoComposeTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalogocompose.model.Routes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MyBox("Android")
                    //MyStateExample()
                    //MyImageAdvanced()
                    //MyComplexScreen()
                    //MyExpensesLayout()
                    //MyProfileLayout()
                    //MyUserCheck()
                    //MainContent()

                    //lista de objetos CheckInfo
                    /*val myOptions = getOptions(titles = listOf("Aris", "Pepe", "Brais"))

                    // seleccion
                    var selected by rememberSaveable {
                        mutableStateOf("Aris")
                    }

                    Column {
                        MyTriStatusCheckBox() //checkBox indeterminado

                        // creando un checkBox por cada elemento de la lista de objetos
                        myOptions.forEach {
                            MyCheckBoxCompleted(checkInfo = it)
                        }
                        
                        MyRadioButtonListStateHoisting(
                            name = selected,
                            onItemSelected = { selected = it }
                        )
                    }*/

                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                    }
                }
            }
        }
    }
}

//ejemplo de uso de estados
/*@Composable
fun MyStateExample() {
    //remember solo mantiene el valor al hacer la recomposicion 
    //var counter = remember { mutableStateOf(0) } // remember para que al recomponerse se mantenga el valor anterior y no sea siempre 0
    
    // ejemplo que mantiene los datos durante el ciclo de vida de la app, por ejemplo al girar la pantalla los datos permanecen
    var counter = rememberSaveable { mutableStateOf(0) }
            

    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Button(onClick = { counter.value++ }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter.value} veces")
    }
}*/


// version para no tener que acceder al value del remember
@Composable
fun MyStateExample() {
    //remember solo mantiene el valor al hacer la recomposicion
    //var counter = remember { mutableStateOf(0) } // remember para que al recomponerse se mantenga el valor anterior y no sea siempre 0

    // ejemplo que mantiene los datos durante el ciclo de vida de la app, por ejemplo al girar la pantalla los datos permanecen
    var counter by rememberSaveable { mutableStateOf(0) }

    /* imports para usar el by
       import androidx.compose.runtime.getValue
       import androidx.compose.runtime.setValue */


    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Button(onClick = { counter++ }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}


@Preview
@Composable
fun MyComplexScreen() {
    Column(
        Modifier
            .fillMaxSize()

    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .weight(1F), contentAlignment = Alignment.Center) {
            Text(text = "Reto 1")


        }
        // espacio en columna
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))
        
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .weight(1F)) {

            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1F), contentAlignment = Alignment.Center) {
                Text(text = "Reto 1")
            }

            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Blue)
                    .weight(1F), contentAlignment = Alignment.Center) {
                Text(text = "Hola soy pepivsky", color = Color.White)
            }


        }
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .weight(1F), contentAlignment = Alignment.BottomCenter) {
            Text(text = "Reto 1")
        }


    }
}

@Composable
fun MyExpensesLayout() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)) {

        Column(Modifier.weight(1F)) {
            Text("Products")
            Text("$10,123.50")
        }

        Row(
            Modifier
                .weight(1F)
                .fillMaxWidth()
                .padding(8.dp), Arrangement.SpaceBetween) {
            Card() {
                Column(modifier = Modifier.background(Color(0xFFEFDAE8))) {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Imagen")
                    Text("TikTok")
                    Text( "-$29.00")

                }
            }

            Card() {
                Column(Modifier.background(Color(0xFFD3EAEB))) {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Imagen")
                    Text("TikTok")
                    Text( "-$29.00")

                }
            }

            Card(Modifier.background(Color.Red)) {
                // #DDD3EB
                Column(Modifier.background(Color(0xFFDDD3EB))) {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Imagen")
                    Text("TikTok")
                    Text( "-$29.00")

                }
            }
        }

        Row(Modifier.weight(1F)) {

        }

        Row(Modifier.weight(1F)) {

        }

    }
}

@Composable
fun MyProfileLayout() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .background(Color.Yellow)
        .fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Cyan)
            , verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.elon),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier
                .width(16.dp))

            Column {
                Text("Elon Musk", fontWeight = FontWeight.Bold)
                Text("5 minutes ago", fontWeight = FontWeight.Light)
            }

        }
    }
}

@Composable
fun MyUserCheck() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
        ) {

        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.elon),
                contentDescription = "Profile check image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_check_circle),
                contentDescription = "check icon",
                tint = Color.Black
            )
        }
    }


}


@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo1", Modifier.background(Color.Red))
        Text(text = "Ejemplo2", Modifier.background(Color.Green))
        Text(text = "Ejemplo3", Modifier.background(Color.Gray))
        Text(text = "Ejemplo4", Modifier.background(Color.Magenta))
    }

}

@Composable
fun MyColumn() {
    /*Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text( "Ejemplo 1", Modifier.background(Color.Cyan).weight(1f))
        Text("Ejemplo 2", Modifier.background(Color.Blue).weight(1f))
        Text( "Ejemplo 3", Modifier.background(Color.Green).weight(1f))
        Text("Ejemplo 4", Modifier.background(Color.Red).weight(1f))

    }*/

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text( "Ejemplo 1", Modifier.background(Color.Cyan))
        Text("Ejemplo 2", Modifier.background(Color.Blue))
        Text( "Ejemplo 3", Modifier.background(Color.Green))
        Text("Ejemplo 4", Modifier.background(Color.Red))

    }

}

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .width(200.dp)
                .height(300.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.Center
        ) {
            Text(text = "Hola $name")
        }
    }
}

//fun Color.fromHex(color: String) = Color(android.graphics.Color.parseColor("#" + colorString))

//Preview muestra la funcion que se coloca aqui
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatalogoComposeTheme {
        //MyBox("Android")
        //MyColumn()
        //MyRow()
        //MyComplexScreen()
        //MyStateExample()
        //MyImageAdvanced()
       //MyExpensesLayout()
        //MyProfileLayout()
        MyUserCheck()
        //MainContent()
    }
}