package com.jamesvanhallen.helsinkiwalker.domain.source.repository

import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto

interface VenueRepository {

    suspend fun getAllVenues(lat: Double, lon: Double): List<VenueDto>

    fun provideLocations(): List<Pair<Double, Double>>

    suspend fun saveFavorite(venue: VenueEntity)

    suspend fun removeFavorite(venue: VenueEntity)

    suspend fun getCachedVenues(): List<VenueEntity>
}