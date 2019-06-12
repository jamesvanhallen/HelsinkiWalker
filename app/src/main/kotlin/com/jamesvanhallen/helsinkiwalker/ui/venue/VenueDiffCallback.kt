package com.jamesvanhallen.helsinkiwalker.ui.venue

import androidx.recyclerview.widget.DiffUtil
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue

class VenueDiffCallback(var newPersons: List<Venue>, var oldPersons: List<Venue>) :
    DiffUtil.Callback() {

    override fun getOldListSize() =  oldPersons.size

    override fun getNewListSize() = newPersons.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition].uuid === newPersons[newItemPosition].uuid
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition] == newPersons[newItemPosition]
    }
}