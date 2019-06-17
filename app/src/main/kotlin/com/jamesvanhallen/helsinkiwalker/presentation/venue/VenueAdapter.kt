package com.jamesvanhallen.helsinkiwalker.presentation.venue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadAnimation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jamesvanhallen.helsinkiwalker.R

class VenueAdapter(
    private val onRatioChangeListener: (Venue) -> Unit
) : RecyclerView.Adapter<VenueHolder>() {

    var items = listOf<Venue>()
        set(value) {
            if (field.isEmpty()) {
                field = value
                notifyDataSetChanged()
            } else {
                val diffResult = DiffUtil.calculateDiff(VenueDiffCallback(field, value))
                diffResult.dispatchUpdatesTo(this)
                field = value
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.holder_venue, parent, false)
        return VenueHolder(view, onRatioChangeListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VenueHolder, position: Int) {
        holder.bind(items[position])
        setAnimation(holder.itemView)
    }

    private fun setAnimation(viewToAnimate: View) {
        val animation = loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
        viewToAnimate.startAnimation(animation)
    }

    override fun onViewDetachedFromWindow(holder: VenueHolder) {
        holder.clearAnimation()
    }
}