package com.boardgames.rick_and_morty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.boardgames.rick_and_morty.Character
import com.boardgames.rick_and_morty.network.ApiService
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getCharacters(page)
            val characters = response.results

            LoadResult.Page(
                data = characters,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (characters.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state
                .closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
