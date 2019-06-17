package com.jamesvanhallen.helsinkiwalker.api

import com.jamesvanhallen.helsinkiwalker.domain.source.response.VenueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueDataSource {

    @GET("venues")
    suspend fun getAllVenues(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): VenueResponse
}