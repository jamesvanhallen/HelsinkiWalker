package com.jamesvanhallen.helsinkiwalker.domain.source.repository

import com.jamesvanhallen.helsinkiwalker.api.VenueDataSource
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueDao
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto

class VenueRepositoryImpl(
    private val venueDataSource: VenueDataSource,
    private val venueDao: VenueDao
) : VenueRepository {

    override suspend fun getAllVenues(lat: Double, lon: Double): List<VenueDto> {
        val venueResponse = venueDataSource.getAllVenues(lat, lon)
        return if (venueResponse.results.size > VENUES_LIMIT) {
            venueResponse.results.subList(0, VENUES_LIMIT - 1)
        } else {
            venueResponse.results
        }
    }

    override suspend fun saveFavorite(venue: VenueEntity) = venueDao.insert(venue)

    override suspend fun removeFavorite(venue: VenueEntity) = venueDao.delete(venue)

    override suspend fun getCachedVenues() = venueDao.fetchAll()

    @Suppress("MagicNumber")
    override fun provideLocations(): List<Pair<Double, Double>> {
        return listOf(
            Pair(60.170187, 24.930599),
            Pair(60.169418, 24.931618),
            Pair(60.169818, 24.932906),
            Pair(60.170005, 24.935105),
            Pair(60.169108, 24.936210),
            Pair(60.168355, 24.934869),
            Pair(60.167560, 24.932562),
            Pair(60.168254, 24.931532),
            Pair(60.169012, 24.930341),
            Pair(60.170085, 24.929569)
        )
    }

    companion object {
        const val VENUES_LIMIT = 15
    }
}