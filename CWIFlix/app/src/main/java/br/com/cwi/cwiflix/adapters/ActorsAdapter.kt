package br.com.cwi.cwiflix.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.cwiflix.R
import br.com.cwi.cwiflix.api.models.Person
import br.com.cwi.cwiflix.api.models.PopularPeople
import br.com.cwi.cwiflix.utils.ImageURLProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_actors.view.*

class ActorsAdapter(val items: List<PopularPeople>, val onClick: (person: PopularPeople) -> Unit) : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_actors, parent, false)
        return ActorsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        Picasso
                .with(holder.itemView.context)
                .load(ImageURLProvider.small(item.image.toString()))
                .into(holder.posterImageButtonActors)

        holder.nameTextViewActors.text = item.name
        holder.posterImageButtonActors.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posterImageButtonActors = itemView.posterImageButtonActors
        val nameTextViewActors = itemView.nameTextViewActors
    }
}