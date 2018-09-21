package br.com.cwi.cwiflix.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.activities.SerieActivity
import br.com.cwi.cwiflix.adapters.MediaAdapter
import br.com.cwi.cwiflix.api.models.Media
import br.com.cwi.cwiflix.api.models.Serie
import br.com.cwi.cwiflix.presenters.SeriesPresenter
import br.com.cwi.cwiflix.views.SeriesView
import kotlinx.android.synthetic.main.fragment_media.*


class SeriesFragment : Fragment(), SeriesView {

    lateinit var adapter: MediaAdapter

    val presenter: SeriesPresenter by lazy {
        SeriesPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter.onCreateView()
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    override fun onResponse(list: List<Media>) {
        adapter = MediaAdapter(list) { media ->
            media.id?.let {
                presenter.getSerieDetail(media.id)
            }
        }

        recyclerView.adapter = adapter
    }

    override fun goToDetail(serie: Serie) {
        val intent = Intent(activity, SerieActivity::class.java)
        intent.putExtra("serie", serie)

        activity?.startActivity(intent)
    }

}
