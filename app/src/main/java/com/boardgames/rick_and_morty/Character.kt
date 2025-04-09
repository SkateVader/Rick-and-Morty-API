package com.boardgames.rick_and_morty

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val location: Location,
    val episode: List<String>
)
