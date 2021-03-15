package com.jamesvanhallen.helsinkiwalker.presentation.venue

import androidx.lifecycle.MutableLiveData
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import com.jamesvanhallen.helsinkiwalker.domain.source.repository.VenueRepository
import com.jamesvanhallen.helsinkiwalker.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.fixedRateTimer

class VenueViewModel(
    private val venueRepository: VenueRepository
) : BaseViewModel() {

    val venues = MutableLiveData<List<Venue>>()

    private var attempt = 0
    var timer: Timer? = null

    fun init() {
        timer = fixedRateTimer(TIMER, false, 0, TIMER_PERIOD) {
            fetchVenues(attempt)
            val incrementAndGet = attempt++
            if (incrementAndGet == venueRepository.provideLocations().size) {
                attempt = 0
            }
        }
    }

    fun fetchVenues(locationNumber: Int) = launchCatching {
        val (lat, lan) = venueRepository.provideLocations()[locationNumber]

        val venuesDtos = venueRepository.getAllVenues(lat, lan)

        val allVenues: MutableList<Venue> = mutableListOf()
        venuesDtos.forEach { venueDto ->
            // val entity = venueEntities.find { venueDto.uuid == it.id }
            allVenues.add(Venue(venueDto))
        }
        venues.postValue(allVenues)
    }

    fun stopTimer() = launchCatching(showProgress = false) {
        delay(DELAY_PERIOD)
        timer?.cancel()
    }

    fun onFavoriteSelected(venue: Venue) = launchCatching(showProgress = false) {
        if (venue.isFavorite) {
            venueRepository.saveFavorite(VenueEntity(venue.uuid))
        } else {
            venueRepository.removeFavorite(VenueEntity(venue.uuid))
        }
    }

    override fun onCleared() {
        timer?.cancel()
        super.onCleared()
    }

    companion object {
        const val TIMER = "timer"
        const val TIMER_PERIOD = 10000L
        const val DELAY_PERIOD = 2000L
    }
}