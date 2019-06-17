package com.jamesvanhallen.helsinkiwalker.domain.database.venue

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VenueDao {

    @Insert
    suspend fun insert(venue: VenueEntity)

    @Delete
    suspend fun delete(venue: VenueEntity)

    @Query("SELECT * FROM venues")
    fun fetchAll(): List<VenueEntity>
}