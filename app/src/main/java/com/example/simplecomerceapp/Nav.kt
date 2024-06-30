package com.example.simplecomerceapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav() {
    val naveControl = rememberNavController()
    NavHost(navController = naveControl , startDestination = "Start"){
        composable(route = "Start"){
            Welcome(naveControl)
        }
        composable(route = "Home"){
            HScreen()
        }
    }
}