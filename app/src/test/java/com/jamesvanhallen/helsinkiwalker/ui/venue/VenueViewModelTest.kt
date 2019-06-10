package com.jamesvanhallen.helsinkiwalker.ui.venue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth
import com.jamesvanhallen.helsinkiwalker.CoroutinesTestRule
import com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import com.jamesvanhallen.helsinkiwalker.testObserver
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit

class VenueViewModelTest {

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var venueRepository: VenueRepository

    @Test
    fun `Emit empty data`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        `when`(venueRepository.allVenues).thenReturn(MutableLiveData<List<Movie>>())
        val viewModel = VenueViewModel(venueRepository)
        val testObserver = viewModel.movies.testObserver()

        Truth.assert_()
            .that(testObserver.observedValues)
            .isEqualTo(emptyList<Movie>())
    }

    @Test
    fun `Emit list of to items`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val movieLiveData = MutableLiveData<List<Movie>>()
        `when`(venueRepository.allVenues).thenReturn(movieLiveData)
        val viewModel = VenueViewModel(venueRepository)
        val testObserver = viewModel.movies.testObserver()
        val testData = listOf(
            Movie(1, "test1", 0.5f, ""),
            Movie(2, "test2", 1f, "")
        )
        movieLiveData.postValue(testData)

        Truth.assert_()
            .that(testObserver.observedValues)
            .isEqualTo(listOf(testData))
    }
}