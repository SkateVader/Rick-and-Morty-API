package com.boardgames.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.boardgames.rick_and_morty.navigation.NavGraph
import com.boardgames.rick_and_morty.viewmodel.CharacterViewModel
import com.boardgames.rick_and_morty.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val characterViewModel: CharacterViewModel = viewModel()
            val locationViewModel: LocationViewModel = viewModel()

            NavGraph(
                navController = navController,
                characterViewModel = characterViewModel,
                locationViewModel = locationViewModel
            )
        }
    }
}
