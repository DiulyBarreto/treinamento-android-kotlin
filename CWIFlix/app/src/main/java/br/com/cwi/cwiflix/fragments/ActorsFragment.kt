package br.com.cwi.cwiflix.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.activities.PersonActivity
import br.com.cwi.cwiflix.adapters.ActorsAdapter
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.api.models.PopularPeople
import br.com.cwi.cwiflix.presenters.ActorsPresenter
import br.com.cwi.cwiflix.views.ActorsView
import kotlinx.android.synthetic.main.fragment_actors.*


class ActorsFragment : Fragment(), ActorsView {

    lateinit var adapter: ActorsAdapter

    private val presenter: ActorsPresenter by lazy {
        ActorsPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.onCreateView()
        return inflater.inflate(R.layout.fragment_actors, container, false)
    }

    override fun onResponse(list: List<PopularPeople>) {
        adapter = ActorsAdapter(list) { person ->
            person.id?.let {
                presenter.getPersonDetail(person.id)
            }
        }
        recyclerViewActors.adapter = adapter
    }

    override fun goToDetail(person: Person) {
        val intent = Intent(activity, PersonActivity::class.java)
        intent.putExtra("person", person)

        activity?.startActivity(intent)
    }
}
