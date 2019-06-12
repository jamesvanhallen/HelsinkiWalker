package com.jamesvanhallen.helsinkiwalker.ui.venue

import androidx.recyclerview.widget.DiffUtil
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue

class VenueDiffCallback(var newVenues: List<Venue>, var oldVenues: List<Venue>) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldVenues.size

    override fun getNewListSize() = newVenues.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldVenues[oldItemPosition].uuid === newVenues[newItemPosition].uuid
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldVenues[oldItemPosition] == newVenues[newItemPosition]
    }
}