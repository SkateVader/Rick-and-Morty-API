package com.boardgames.rick_and_morty.network

import com.boardgames.rick_and_morty.Location

data class LocationResponse(
    val results: List<Location>
)