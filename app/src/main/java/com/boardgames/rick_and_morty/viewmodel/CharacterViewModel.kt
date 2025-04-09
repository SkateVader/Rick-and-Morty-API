package com.boardgames.rick_and_morty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.boardgames.rick_and_morty.Character
import com.boardgames.rick_and_morty.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characterPagingData: Flow<PagingData<Character>> =
        repository.getCharacters().cachedIn(viewModelScope)

}
