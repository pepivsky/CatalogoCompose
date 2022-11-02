package com.example.catalogocompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.catalogocompose.model.Routes

/*
Ejemplo de navegacion entre pantallas, el navigationController se declara en el mainActivity
 */

// Pantalla 1
@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla2.createRoute(34)) })
    }
}

// Pantalla 2
@Composable
fun Screen2(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla 2 tengo:$age anios",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla3.route) })
    }
}

// Pantalla 3
@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla4.createRoute("Aristidevs")) })
    }
}

// Pantalla 4
@Composable
fun Screen4(navigationController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Pantalla 4 $name", modifier = Modifier.align(Alignment.Center))
    }
}

