package com.boardgames.rick_and_morty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.boardgames.rick_and_morty.Location
import com.boardgames.rick_and_morty.network.ApiService
import retrofit2.HttpException
import java.io.IOException

class LocationPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, Location>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getLocations(page)
            val locations = response.results

            LoadResult.Page(
                data = locations,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (locations.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state
                .closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
