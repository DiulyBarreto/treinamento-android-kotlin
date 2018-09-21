package br.com.cwi.cwiflix.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.activities.MovieActivity
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.adapters.MediaAdapter
import br.com.cwi.cwiflix.api.models.Media
import br.com.cwi.cwiflix.api.models.Movie
import br.com.cwi.cwiflix.presenters.MoviesPresenter
import br.com.cwi.cwiflix.views.MoviesView
import kotlinx.android.synthetic.main.fragment_media.*

class MoviesFragment: Fragment(), MoviesView {

    lateinit var adapter: MediaAdapter

    private val presenter: MoviesPresenter by lazy {
        MoviesPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.onCreateView()
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    override fun onResponse(list: List<Media>) {
        adapter = MediaAdapter(list) { media ->
            media.id?.let {
                presenter.getMovieDetail(media.id)
            }
        }

        recyclerView.adapter = adapter
    }

    override fun goToDetail(movie: Movie) {
        val intent = Intent(activity, MovieActivity::class.java)
        intent.putExtra("movie", movie)

        activity?.startActivity(intent)
    }
}
