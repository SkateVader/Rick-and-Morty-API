package com.boardgames.rick_and_morty

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val name: String,
    val episode: String,
    val airDate: String
) : Parcelable

