package com.boardgames.rick_and_morty.network

import com.boardgames.rick_and_morty.Episode
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse

    @GET("location")
    suspend fun getLocations(@Query("page") page: Int): LocationResponse

    @GET
    suspend fun getEpisode(@Url url: String): Episode
}