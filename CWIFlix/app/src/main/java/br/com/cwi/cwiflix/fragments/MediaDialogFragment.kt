package br.com.cwi.cwiflix.fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.SharedPreferencesService
import br.com.cwi.cwiflix.api.models.Media
import kotlinx.android.synthetic.main.dialog_media.*
import kotlinx.android.synthetic.main.dialog_media.view.*

class MediaDialogFragment: DialogFragment() {

    lateinit var media: Media

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.dialog_media, container, false)

        media.run {
            view.titleTextView.text = title
            view.overviewTextView.text = overview
            view.dateTextView.text = releaseDate
            view.average.text = "$voteAverage/10"
        }

        view.mediaRatingBar.setOnRatingBarChangeListener {ratingBar, rating, _ ->
            myRatingTextView.text = "${(rating * 2).toInt()}/10"
            SharedPreferencesService.writeMediaRating(media.id, rating)
        }


        return view
    }
}