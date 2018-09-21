package br.com.cwi.cwiflix.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.utils.ImageURLProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {

    private var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        person = intent.getSerializableExtra("person") as Person
        person?.let {
            Picasso.with(this).load(ImageURLProvider.large(it.image!!)).into(posterImageViewPerson)
            namePersonTextView.text = it.name
            biographyTextView.text = it.biography
        }
    }
}
