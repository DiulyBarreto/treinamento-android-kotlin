package br.com.cwi.cwiflix.presenters

import android.util.Log
import br.com.cwi.cwiflix.api.MovieDatabaseService
import br.com.cwi.cwiflix.api.models.PeopleResult
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.views.ActorsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActorsPresenter(val view: ActorsView): Callback<PeopleResult> {

    fun onCreateView() {
        MovieDatabaseService.service.getPopularPeople().enqueue(this)
    }


    override fun onFailure(call: Call<PeopleResult>?, t: Throwable?) {
        Log.e("ActorsFramgment", t?.localizedMessage, t)
    }

    override fun onResponse(call: Call<PeopleResult>?, response: Response<PeopleResult>?) {
        response?.body()?.results?.let {
            view.onResponse(it)
        }
    }

    fun getPersonDetail(id: Int) {
        val request = MovieDatabaseService.service.getPersonDetail(id)

        request.enqueue(object : Callback<Person> {

            override fun onResponse(call: Call<Person>?, response: Response<Person>?) {
                response?.body()?.let {
                    view.goToDetail(it)
                }
            }

            override fun onFailure(call: Call<Person>?, t: Throwable?) {
                Log.e("rsponse", t.toString())
            }
        })
    }
}