package com.boardgames.rick_and_morty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterItem(character: Character, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = { onClick() }
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = character.image.ifEmpty { R.drawable.ic_rick_and_morty }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = character.name, style = MaterialTheme.typography.titleLarge)
                Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
