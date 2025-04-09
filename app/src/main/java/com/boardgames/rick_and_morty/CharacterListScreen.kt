package com.boardgames.rick_and_morty

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CharacterListScreen(navController: NavController, characters: LazyPagingItems<Character>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters.itemCount) { index ->
            characters[index]?.let {
                CharacterItem(character = it) {
                    navController.navigate("characterDetails/${it.id}")
                }
            }
        }
    }
}
