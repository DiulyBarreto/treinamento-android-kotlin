package br.com.cwi.cwiflix.api.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediaResult(val results: List<Media>)

class Media(
        val id: Int,
        @SerializedName("title", alternate = ["name"]) val title: String,
        @SerializedName("poster_path", alternate = ["profile_path"]) val image: String,
        @SerializedName("release_date", alternate = ["first_air_date"]) val releaseDate: String,
        @SerializedName("vote_average")val voteAverage: Double,
        val overview: String
)

class Movie: Serializable {

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("tagline")
    var tagline: String? = null

    @SerializedName("overview")
    var overview: String? = null
}

class Serie : Serializable {

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("original_name")
    var originalName: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("overview")
    var overview: String? = null
}

class Person: Serializable {

    var profilePath: String? = null
    var name: String? = null
    var biography: String? = null
}
