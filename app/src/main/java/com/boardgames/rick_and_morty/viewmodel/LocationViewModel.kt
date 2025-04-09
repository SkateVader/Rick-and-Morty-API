package com.boardgames.rick_and_morty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.boardgames.rick_and_morty.Location
import com.boardgames.rick_and_morty.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {

    val locationPagingData: Flow<PagingData<Location>> =
        repository.getLocations().cachedIn(viewModelScope)
}
