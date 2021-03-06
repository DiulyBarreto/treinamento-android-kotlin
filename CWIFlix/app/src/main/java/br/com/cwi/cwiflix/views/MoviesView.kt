package br.com.cwi.cwiflix.views

import br.com.cwi.cwiflix.api.models.Media
import br.com.cwi.cwiflix.api.models.Movie

interface MoviesView {
    fun onResponse(list: List<Media>)
    fun goToDetail(movie: Movie)
}