package br.com.cwi.cwiflix.api

import br.com.cwi.cwiflix.api.models.MediaResult
import br.com.cwi.cwiflix.api.models.Movie
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.api.models.Serie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieDatabaseService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<MediaResult>

    @GET("tv/popular")
    fun getPopularTvShows(): Call<MediaResult>

    @GET("person/popular")
    fun getPopularPeople(): Call<MediaResult>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") id: Int) : Call<Movie>

    @GET("tv/{tv_id}")
    fun getTvDetail(@Path("tv_id") id: Int) : Call<Serie>

    @GET("person/{person_id}")
    fun getPersonDetail(@Path("person_id") id: Int) : Call<Person>
}