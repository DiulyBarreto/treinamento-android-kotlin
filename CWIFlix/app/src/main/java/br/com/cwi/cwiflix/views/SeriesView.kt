package br.com.cwi.cwiflix.views

import br.com.cwi.cwiflix.api.models.Media
import br.com.cwi.cwiflix.api.models.Serie

interface SeriesView {
    fun onResponse(list: List<Media>)
    fun goToDetail(serie: Serie)
}