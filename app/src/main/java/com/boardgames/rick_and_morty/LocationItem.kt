package com.boardgames.rick_and_morty

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LocationItem(location: Location) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = location.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Type: ${location.type}", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Dimension: ${location.dimension}", style = MaterialTheme
                    .typography.bodyMedium
            )
        }
    }
}
