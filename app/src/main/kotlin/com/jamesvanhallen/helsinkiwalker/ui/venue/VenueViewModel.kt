package com.jamesvanhallen.helsinkiwalker.ui.venue

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.await

class VenueViewModel(
    private val venueRepository: VenueRepository
) : ViewModel() {

    val movies = MutableLiveData<List<Venue>>()

    init {
        onCreate()
    }

    private fun onCreate() = viewModelScope.launch(Dispatchers.IO) {
        val venues = venueRepository.getAllVenues(60.170187, 24.930599)
        Log.d("AAA", "venues " + venues.size)
       // withContext(Dispatchers.Main) {
//            try {
//                if (venues.isSuccessful) {
//                    //Do something with response e.g show to the UI.
//                } else {
//                    toast("Error: ${response.code()}")
//                }
//            } catch (e: HttpException) {
//                toast("Exception ${e.message}")
//            } catch (e: Throwable) {
//                toast("Ooops: Something else went wrong")
//            }
        //}

    }

//    companion object {
//        private const val ONE_SECOND = 1000
//        private const val MAX_RANDOM_DELAY = 10000L
//        private const val MIN_RANDOM_DELAY = 3000L
//        private const val MAX_RATIO = 5
//    }
}