package com.example.mycomposeapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun HomeNavController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController)
        }
        composable("callScreen"){
            callScreen()
        }
        composable("MusicScreen"){
            MusicScreen()
        }
        composable("DriveScreen"){
            DriveScreen()
        }
        composable("HomeDetailsScreen"){backstackentry->
            HomeDetailsScreen(navController)
        }
    }
}