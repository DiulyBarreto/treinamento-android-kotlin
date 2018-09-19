package br.com.cwi.cwiflix.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.api.models.Serie
import br.com.cwi.cwiflix.utils.ImageURLProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_serie.*

class SerieActivity : AppCompatActivity() {

    private var serie: Serie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        serie = intent.getSerializableExtra("serie") as Serie

        serie?.let {
            showSerieDetails(it)
        }
    }

    private fun showSerieDetails(serie: Serie) {
        Picasso.with(this).load(ImageURLProvider.large(serie.backdropPath!!)).into(posterImageView)
        originalTitleTextView.text = serie.originalName
        overviewTitleTextView.text = serie.overview
        originalLanguageTextView.text = serie.originalLanguage
    }
}
