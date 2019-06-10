package com.jamesvanhallen.helsinkiwalker.ui.venue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamesvanhallen.helsinkiwalker.R
import com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie

class MovieAdapter(
    private val onRatioChangeListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieHolder>() {

    var items = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.holder_movie, parent, false)
        return MovieHolder(view, onRatioChangeListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(items[position])
    }
}