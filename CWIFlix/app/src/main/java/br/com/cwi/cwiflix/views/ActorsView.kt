package br.com.cwi.cwiflix.views

import br.com.cwi.cwiflix.api.models.Media
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.api.models.PopularPeople

interface ActorsView {
    fun onResponse(list: List<PopularPeople>)
    fun goToDetail(person: Person)
}