package com.jamesvanhallen.helsinkiwalker.domain.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class AppDataBaseTest {

    private lateinit var db: AppDataBase

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `Test not empty data after insert`() = runBlocking {

        // Arrange
        val testVenue = VenueEntity("1")

        // Act
        db.venueDao.insert(testVenue)

        // Assert
        val venues = db.venueDao.fetchAll()
        assert(venues.isNotEmpty())
    }

    @Test
    fun `Test empty data after remove`() = runBlocking {

        // Arrange
        val testVenue = VenueEntity("1")
        val venueDao = db.venueDao
        venueDao.insert(testVenue)

        // Act
        venueDao.delete(testVenue)

        // Assert
        val venues = venueDao.fetchAll()
        assert(venues.isEmpty())
    }
}