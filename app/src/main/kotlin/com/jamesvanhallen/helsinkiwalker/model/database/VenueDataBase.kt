package com.jamesvanhallen.helsinkiwalker.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jamesvanhallen.helsinkiwalker.model.database.venue.VenueDao
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue

@Database(
    entities = [Venue::class],
    version = 1,
    exportSchema = false
)
abstract class VenueDataBase : RoomDatabase() {

    abstract val movieDao: VenueDao

    companion object {
        const val VENUES_TABLE_NAME = "venues"
        const val VENUES_DATABASE_NAME = "venues_database"
    }
}