package com.example.project3

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("overview")
    val overview: String? = null
) {
    fun getPosterUrl(): String {
        return "https://image.tmdb.org/t/p/w500/$posterPath"
    }
}