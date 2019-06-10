package com.jamesvanhallen.helsinkiwalker.model.source.response

import com.google.gson.annotations.SerializedName
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue

data class VenueResponse (
    @SerializedName("results") val results: List<Venue>
)