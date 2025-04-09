package com.boardgames.rick_and_morty.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.boardgames.rick_and_morty.CharacterListScreen
import com.boardgames.rick_and_morty.CharacterDetailScreen
import com.boardgames.rick_and_morty.viewmodel.CharacterViewModel
import com.boardgames.rick_and_morty.viewmodel.LocationViewModel
import com.boardgames.rick_and_morty.viewmodel.EpisodeViewModel
import kotlinx.coroutines.runBlocking
import com.boardgames.rick_and_morty.Episode
import com.boardgames.rick_and_morty.LocationListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    characterViewModel: CharacterViewModel = viewModel(),
    locationViewModel: LocationViewModel = viewModel(),
    episodeViewModel: EpisodeViewModel = viewModel()
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "characterList",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("characterList") {
                val characters = characterViewModel.characterPagingData.collectAsLazyPagingItems()
                val isLoading = characters.loadState.refresh is androidx.paging.LoadState.Loading

                Box(modifier = Modifier.fillMaxSize()) {
                    CharacterListScreen(navController, characters)
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp)
                        )
                    }
                }
            }
            composable("characterDetails/{characterId}") { backStackEntry ->
                val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                val characters = characterViewModel.characterPagingData.collectAsLazyPagingItems()
                val character = characters.itemSnapshotList.items.find { it.id == characterId }

                character?.let {
                    val episodes: List<Episode> = runBlocking {
                        it.episode.mapNotNull { url ->
                            episodeViewModel.getEpisodeByUrl(url)
                        }
                    }
                    CharacterDetailScreen(it, episodes)
                }
            }
            composable("locationList") {
                val locations = locationViewModel.locationPagingData.collectAsLazyPagingItems()
                val isLoading = locations.loadState.refresh is androidx.paging.LoadState.Loading

                Box(modifier = Modifier.fillMaxSize()) {
                    LocationListScreen(locations)
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp)
                        )
                    }
                }
            }
        }
    }
}
