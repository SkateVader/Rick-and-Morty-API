package com.boardgames.rick_and_morty.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.boardgames.rick_and_morty.Character
import com.boardgames.rick_and_morty.network.ApiService
import com.boardgames.rick_and_morty.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val api: ApiService
) {
    fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { CharacterPagingSource(api) }
        ).flow
    }
}
