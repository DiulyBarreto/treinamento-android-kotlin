package br.com.cwi.cwiflix.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.cwi.cwiflix.BuildConfig
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.adapters.MediaAdapter
import br.com.cwi.cwiflix.api.MovieDatabaseService
import br.com.cwi.cwiflix.api.models.MediaResult
import kotlinx.android.synthetic.main.fragment_media.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeriesFragment : Fragment(), Callback<MediaResult> {

    lateinit var adapter: MediaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        MovieDatabaseService.service.getPopularTvShows().enqueue(this)
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    override fun onFailure(call: Call<MediaResult>, t: Throwable) {
        Log.e("SeriesFramgment", t.localizedMessage, t)
    }

    override fun onResponse(call: Call<MediaResult>?, response: Response<MediaResult>) {
        response.body()?.results?.let {
            adapter = MediaAdapter(it) {media ->
                Toast.makeText(context, media.title, Toast.LENGTH_SHORT).show()
            }
            recyclerView.adapter = adapter
        }
    }
}
