package br.com.cwi.cwiflix.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.activities.SerieActivity
import br.com.cwi.cwiflix.adapters.ActorsAdapter
import br.com.cwi.cwiflix.api.MovieDatabaseService
import br.com.cwi.cwiflix.api.models.MediaResult
import br.com.cwi.cwiflix.api.models.Serie
import kotlinx.android.synthetic.main.fragment_actors.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActorsFragment : Fragment(), Callback<MediaResult> {

    lateinit var adapter: ActorsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MovieDatabaseService.service.getPopularPeople().enqueue(this)
        return inflater.inflate(R.layout.fragment_actors, container, false)
    }

    override fun onFailure(call: Call<MediaResult>, t: Throwable) {
        Log.e("ActorsFramgment", t.localizedMessage, t)
    }

    override fun onResponse(call: Call<MediaResult>?, response: Response<MediaResult>) {
        response.body()?.results?.let {
            adapter = ActorsAdapter(it) { serie ->
                serie.id?.let {
                    getSerieDetail(serie.id)
                }
            }
            recyclerViewActors.adapter = adapter
        }
    }

    private fun getSerieDetail(id: Int) {
        val request = MovieDatabaseService.service.getTvDetail(id)

        request.enqueue(object : Callback<Serie> {

            override fun onResponse(call: Call<Serie>?, response: Response<Serie>?) {
                val  intent = Intent(activity, SerieActivity::class.java)
                intent.putExtra("serie", response?.body())

                activity?.startActivity(intent)
            }

            override fun onFailure(call: Call<Serie>?, t: Throwable?) {
                Log.e("rsponse", t.toString())
            }
        })
    }
}
