package com.jamesvanhallen.helsinkiwalker.model.database.venue

import androidx.room.*

@Dao
interface VenueDao {

    @Insert
    suspend fun insert(venue: Venue)

    @Delete
    suspend fun delete(venue: Venue)

    @Query("SELECT * FROM venues")
    fun fetchAll(): List<Venue>
}