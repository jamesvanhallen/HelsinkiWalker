package com.jamesvanhallen.helsinkiwalker.presentation.venue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.jamesvanhallen.helsinkiwalker.CoroutinesTestRule
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto
import com.jamesvanhallen.helsinkiwalker.domain.source.repository.VenueRepository
import com.jamesvanhallen.helsinkiwalker.utils.test
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyDouble
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class VenueViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `Emit empty data`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        // Arrange
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(emptyList())
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.5, 0.3)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val testObserver = viewModel.venues.test()

        // Act
        viewModel.fetchVenues(0)

        // Assert
        Truth.assert_()
            .that(testObserver.observedValues)
            .isEqualTo(listOf(emptyList<String>()))
    }

    @Test
    fun `Emit list of two items`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        // Arrange
        val testData = listOf(
            VenueDto("1", "test1", "", ""),
            VenueDto("2", "test2", "", "")
        )
        val expectedResponse = listOf(
            Venue(testData[0]),
            Venue(testData[1])
        )
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(testData)
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.0, 0.6)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val testObserver = viewModel.venues.test()

        // Act
        viewModel.fetchVenues(0)

        // Assert
        Truth.assert_()
            .that(testObserver.observedValues)
            .isEqualTo(listOf(expectedResponse))
    }

    @Test
    fun `Test on error`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        // Arrange
        val venueRepository = mock(VenueRepository::class.java)
        `when`(venueRepository.getAllVenues(anyDouble(), anyDouble())).thenReturn(listOf())
        `when`(venueRepository.provideLocations()).thenReturn(listOf(Pair(0.0, 0.6)))
        `when`(venueRepository.getCachedVenues()).thenReturn(emptyList())
        val viewModel = VenueViewModel(venueRepository)
        val testObserver = viewModel.error.test()

        // Act
        viewModel.fetchVenues(6)

        // Assert
        Truth.assert_()
            .that(testObserver.observedValues[0])
            .isInstanceOf(IndexOutOfBoundsException::class.java)
    }

    @Test
    fun `Test favorite`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        // Arrange
        val venueRepository = mock(VenueRepository::class.java)
        val viewModel = VenueViewModel(venueRepository)
        val venue = Venue(VenueDto("1", "test1", "", "")).apply {
            isFavorite = true
        }

        // Act
        viewModel.onFavoriteSelected(venue)

        // Assert
        verify(venueRepository).saveFavorite(VenueEntity(venue.uuid))

        // Act
        venue.isFavorite = false
        viewModel.onFavoriteSelected(venue)

        // Assert
        verify(venueRepository).removeFavorite(VenueEntity(venue.uuid))
    }
}