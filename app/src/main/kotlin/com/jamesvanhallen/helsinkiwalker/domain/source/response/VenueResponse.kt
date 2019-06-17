package com.jamesvanhallen.helsinkiwalker.domain.source.response

import com.google.gson.annotations.SerializedName
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto

data class VenueResponse (
    @SerializedName("results") val results: List<VenueDto>
)