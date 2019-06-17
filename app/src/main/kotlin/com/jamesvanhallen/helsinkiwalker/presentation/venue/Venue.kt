package com.jamesvanhallen.helsinkiwalker.presentation.venue

import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto

class Venue(dto: VenueDto) {
    val uuid = dto.uuid
    val name = dto.name
    val description = dto.description
    val image = dto.image
    var isFavorite = false
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Venue

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }
}