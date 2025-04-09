package com.boardgames.rick_and_morty.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Characters") },
            label = { Text("Characters") },
            selected = false,
            onClick = { navController.navigate("characterList") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Place, contentDescription = "Locations") },
            label = { Text("Locations") },
            selected = false,
            onClick = { navController.navigate("locationList") }
        )
    }
}

