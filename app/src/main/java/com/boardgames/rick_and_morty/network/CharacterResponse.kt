package com.boardgames.rick_and_morty.network

import com.boardgames.rick_and_morty.Character

data class CharacterResponse(
    val results: List<Character>
)