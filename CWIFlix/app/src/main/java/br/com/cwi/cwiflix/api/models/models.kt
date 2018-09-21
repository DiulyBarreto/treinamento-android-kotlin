package br.com.cwi.cwiflix.api.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediaResult(val results: List<Media>)
class PeopleResult(val results: List<PopularPeople>)

class Media (
        val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val image: String,
        @SerializedName("release_date", alternate = ["first_air_date"]) val releaseDate: String,
        @SerializedName("vote_average")val voteAverage: Double,
        val overview: String
)

class PopularPeople (
        val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("profile_path") val image: String
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
    @SerializedName("profile_path")
    var image: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("biography")
    var biography: String? = null
}


