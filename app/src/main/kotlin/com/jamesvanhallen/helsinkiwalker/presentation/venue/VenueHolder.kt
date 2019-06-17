package com.jamesvanhallen.helsinkiwalker.presentation.venue

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.holder_venue.*

class VenueHolder(
    override val containerView: View,
    private val onFavoriteClickListener: (Venue) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private lateinit var venue: Venue

    init {
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            venue.isFavorite = isChecked
            onFavoriteClickListener.invoke(venue)
        }
    }

    fun bind(venue: Venue) {
        this.venue = venue
        checkbox.isChecked = venue.isFavorite
        tvName.text = venue.name
        tvDescription.text = venue.description
        ivCover.setImageURI(venue.image)
    }

    fun clearAnimation() {
        containerView.clearAnimation()
    }
}