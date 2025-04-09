package com.boardgames.rick_and_morty

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LocationListScreen(locations: LazyPagingItems<Location>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(locations.itemCount) { index ->
            locations[index]?.let { location ->
                LocationItem(location = location)
            }
        }
    }
}
