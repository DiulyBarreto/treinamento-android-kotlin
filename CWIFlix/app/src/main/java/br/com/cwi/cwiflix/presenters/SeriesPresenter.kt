package br.com.cwi.cwiflix.presenters

import android.util.Log
import br.com.cwi.cwiflix.api.MovieDatabaseService
import br.com.cwi.cwiflix.api.models.MediaResult
import br.com.cwi.cwiflix.api.models.Serie
import br.com.cwi.cwiflix.views.SeriesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesPresenter(val view: SeriesView): Callback<MediaResult> {

    fun onCreateView() {
        MovieDatabaseService.service.getPopularTvShows().enqueue(this)
    }

    override fun onFailure(call: Call<MediaResult>?, t: Throwable?) {
        Log.e("SeriesFragment", t?.localizedMessage, t)
    }

    override fun onResponse(call: Call<MediaResult>?, response: Response<MediaResult>?) {
        response?.body()?.results?.let {
            view.onResponse(it)
        }
    }

    fun getSerieDetail(id: Int) {
        val request = MovieDatabaseService.service.getTvDetail(id)

        request.enqueue(object : Callback<Serie> {

            override fun onResponse(call: Call<Serie>?, response: Response<Serie>?) {
                response?.body()?.let {
                    view.goToDetail(it)
                }
            }

            override fun onFailure(call: Call<Serie>?, t: Throwable?) {
                Log.e("rsponse", t.toString())
            }
        })
    }
}