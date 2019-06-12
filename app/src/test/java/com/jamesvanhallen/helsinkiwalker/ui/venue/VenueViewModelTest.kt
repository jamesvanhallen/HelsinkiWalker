package com.jamesvanhallen.helsinkiwalker.ui.venue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jamesvanhallen.helsinkiwalker.CoroutinesTestRule
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class VenueViewModelTest {

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `Emit empty data`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(emptyList())
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.5, 0.3)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val observer = mock(Observer::class.java) as Observer<List<Venue>>
        viewModel.venues.observeForever(observer)

        viewModel.fetchVenues(0)

        verify(observer).onChanged(emptyList())
    }

    @Test
    fun `Emit list of two items`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val testData = listOf(
            Venue("1", "test1", "", "", false),
            Venue("2", "test2", "", "", false)
        )
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(testData)
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.0, 0.6)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val observer = mock(Observer::class.java) as Observer<List<Venue>>
        viewModel.venues.observeForever(observer)

        viewModel.fetchVenues(0)

        verify(observer).onChanged(testData)
    }

    @Test
    fun `Test on error`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(listOf())
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.0, 0.6)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val observer = mock(Observer::class.java) as Observer<Throwable?>
        viewModel.error.observeForever(observer)

        viewModel.fetchVenues(6)

        verify(observer).onChanged(any<IndexOutOfBoundsException>())
    }

    @Test
    fun `Test favorite`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val venueRepository = mock(VenueRepository::class.java)
        val viewModel = VenueViewModel(venueRepository)

        val venue = Venue("1", "test1", "", "", true)
        viewModel.onFavoriteSelected(venue)

        verify(venueRepository).saveFavorite(venue)

        venue.isFavorite = false
        viewModel.onFavoriteSelected(venue)

        verify(venueRepository).removeFavorite(venue)
    }
}