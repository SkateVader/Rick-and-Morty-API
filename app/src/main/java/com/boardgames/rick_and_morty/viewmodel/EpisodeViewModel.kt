package com.boardgames.rick_and_morty.viewmodel

import androidx.lifecycle.ViewModel
import com.boardgames.rick_and_morty.Episode
import com.boardgames.rick_and_morty.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {

    fun getEpisodeByUrl(url: String): Episode? {
        return runBlocking {
            repository.getEpisodeByUrl(url).firstOrNull()
        }
    }
}