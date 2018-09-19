package br.com.cwi.cwiflix.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.api.models.Person

class PersonActivity : AppCompatActivity() {

    private var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
    }
}
