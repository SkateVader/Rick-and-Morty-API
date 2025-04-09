package com.boardgames.rick_and_morty.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.boardgames.rick_and_morty.Location
import com.boardgames.rick_and_morty.network.ApiService
import com.boardgames.rick_and_morty.paging.LocationPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getLocations(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { LocationPagingSource(apiService) }
        ).flow
    }
}
