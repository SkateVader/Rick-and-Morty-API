package com.boardgames.rick_and_morty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterDetailScreen(character: Character, episodes: List<Episode>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                model = character.image.ifEmpty { R.drawable.ic_rick_and_morty }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = character.name, style = MaterialTheme.typography.headlineLarge)
        Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Last known location: ${character.location.name}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Episodes:", style = MaterialTheme.typography.titleLarge)
        LazyColumn {
            items(episodes) { episode ->
                EpisodeItem(episode)
            }
        }
    }
}
