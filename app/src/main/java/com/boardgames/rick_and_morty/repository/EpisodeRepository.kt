package com.boardgames.rick_and_morty.repository

import com.boardgames.rick_and_morty.Episode
import com.boardgames.rick_and_morty.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodeRepository @Inject constructor(
    private val api: ApiService
) {

    fun getEpisodeByUrl(url: String): Flow<Episode?> = flow {
        val response = api.getEpisode(url)
        emit(response)
    }
}
