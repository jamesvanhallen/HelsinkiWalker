package com.jamesvanhallen.helsinkiwalker.presentation.venue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import com.jamesvanhallen.helsinkiwalker.domain.source.repository.VenueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.fixedRateTimer

class VenueViewModel(
    private val venueRepository: VenueRepository
) : ViewModel() {

    val venues = MutableLiveData<List<Venue>>()
    val error = MutableLiveData<Throwable>()
    val loading = MutableLiveData<Boolean>()

    private var attempt: AtomicInteger = AtomicInteger(0)
    var timer: Timer? = null

    fun init() {
        timer = fixedRateTimer(TIMER, false, 0, TIMER_PERIOD) {
            fetchVenues(attempt.get())
            val incrementAndGet = attempt.incrementAndGet()
            if (incrementAndGet == venueRepository.provideLocations().size) {
                attempt = AtomicInteger(0)
            }
        }
    }

    fun fetchVenues(locationNumber: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val (lat, lan) = venueRepository.provideLocations()[locationNumber]
            error.postValue(null)
            loading.postValue(true)
            val venuesDtos = venueRepository.getAllVenues(lat, lan)
            val venueEntities = venueRepository.getCachedVenues()
            val allVenues: MutableList<Venue> = mutableListOf()
            venuesDtos.forEach { venueDto ->
                val entity = venueEntities.find { venueDto.uuid == it.id }
                allVenues.add(Venue(venueDto).apply {
                    isFavorite = entity != null
                })
            }
            venues.postValue(allVenues)
        } catch (throwable: Throwable) {
            error.postValue(throwable)
        } finally {
            loading.postValue(false)
        }
    }

    fun stopTimer() = viewModelScope.launch(Dispatchers.IO) {
        delay(DELAY_PERIOD)
        timer?.cancel()
    }

    fun onFavoriteSelected(venue: Venue) = viewModelScope.launch(Dispatchers.IO) {
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