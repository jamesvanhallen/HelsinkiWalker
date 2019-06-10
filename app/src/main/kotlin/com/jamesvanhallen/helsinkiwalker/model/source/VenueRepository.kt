package com.jamesvanhallen.helsinkiwalker.model.source

import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import kotlinx.coroutines.Deferred

interface VenueRepository {

    suspend fun getAllVenues(lat: Double, lon: Double): List<Venue>

}