package com.jamesvanhallen.helsinkiwalker.model.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class VenueDataBaseTest {

    private lateinit var db: VenueDataBase

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            VenueDataBase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `Test not empty data after insert`() = runBlocking {

        // Arrange
        val testVenue = Venue("1", "test1", "", "", false)

        // Act
        db.movieDao.insert(testVenue)

        // Assert
        val venues = db.movieDao.fetchAll()
        assert(venues.isNotEmpty())
    }

    @Test
    fun `Test empty data after remove`() = runBlocking {

        // Arrange
        val testVenue = Venue("1", "test1", "", "", false)
        val movieDao = db.movieDao
        movieDao.insert(testVenue)

        // Act
        movieDao.delete(testVenue)

        // Assert
        val venues = movieDao.fetchAll()
        assert(venues.isEmpty())
    }
}