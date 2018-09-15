package br.com.cwi.cwiflix.api.models

import com.google.gson.annotations.SerializedName

class MediaResult(val results: List<Media>)

class Media(
        val id: Int,
        @SerializedName("title", alternate = ["name"]) val title: String,
        @SerializedName("poster_path", alternate = ["profile_path"]) val image: String,
        @SerializedName("release_date", alternate = ["first_air_date"]) val releaseDate: String,
        @SerializedName("vote_average")val voteAverage: Double,
        val overview: String
)