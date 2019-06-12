package com.jamesvanhallen.helsinkiwalker.model.source

import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue

interface VenueRepository {

    suspend fun getAllVenues(lat: Double, lon: Double): List<Venue>

    fun provideLocations(): List<Pair<Double, Double>>

    suspend fun saveFavorite(venue: Venue)

    suspend fun removeFavorite(venue: Venue)

    suspend fun getCachedVenues(): List<Venue>
}