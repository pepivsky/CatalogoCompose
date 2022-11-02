package com.example.catalogocompose.model

sealed class Routes(val route: String) {
    object Pantalla1 : Routes("pantalla1")

    object Pantalla2 : Routes("pantalla2/{age}") {
        const val KEY_AGE = "age"
        fun createRoute(age: Int) = "pantalla2/$age"
    }

    object Pantalla3 : Routes("pantalla3")

    object Pantalla4 : Routes("pantalla4/{name}") {
        const val KEY_NAME = "name"
        fun createRoute(name: String) = "pantalla4/$name"
    }

}
