package com.boardgames.rick_and_morty.network

import com.boardgames.rick_and_morty.Episode
import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info") val info: PageInfo,
    @SerializedName("results") val results: List<Episode>
)

data class PageInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)
