package com.jamesvanhallen.helsinkiwalker.api

import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueDataSource {

    @GET("venues")
    fun getAllVenues(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Deferred<List<Venue>>
}