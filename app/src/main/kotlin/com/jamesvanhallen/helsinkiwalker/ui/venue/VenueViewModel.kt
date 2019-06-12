package com.jamesvanhallen.helsinkiwalker.ui.venue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.fixedRateTimer

class VenueViewModel(
    private val venueRepository: VenueRepository
) : ViewModel() {

    val venues = MutableLiveData<List<Venue>>()
    val error = MutableLiveData<Throwable?>()
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
            val allVenues = venueRepository.getAllVenues(lat, lan)
            val cachedVenues = venueRepository.getCachedVenues()
            cachedVenues.forEach { venue -> allVenues.find { venue == it }?.isFavorite = true }
            venues.postValue(allVenues)
        } catch (throwable: Throwable) {
            error.postValue(throwable)
        } finally {
            loading.postValue(false)
        }
    }

    fun onFavoriteSelected(venue: Venue) = viewModelScope.launch(Dispatchers.IO) {
        if (venue.isFavorite) {
            venueRepository.saveFavorite(venue)
        } else {
            venueRepository.removeFavorite(venue)
        }
    }

    override fun onCleared() {
        timer?.cancel()
        super.onCleared()
    }

    companion object {
        const val TIMER = "timer"
        const val TIMER_PERIOD = 10000L
    }
}