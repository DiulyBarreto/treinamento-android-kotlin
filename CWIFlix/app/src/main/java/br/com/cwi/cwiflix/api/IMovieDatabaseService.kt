package br.com.cwi.cwiflix.api

import br.com.cwi.cwiflix.api.models.MediaResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieDatabaseService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<MediaResult>

    @GET("tv/popular")
    fun getPopularTvShows(): Call<MediaResult>

    @GET("person/popular")
    fun getPopularPeople(): Call<MediaResult>
}