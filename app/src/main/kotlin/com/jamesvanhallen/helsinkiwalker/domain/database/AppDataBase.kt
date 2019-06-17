package com.jamesvanhallen.helsinkiwalker.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueDao
import com.jamesvanhallen.helsinkiwalker.domain.database.venue.VenueEntity

@Database(
    entities = [VenueEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract val venueDao: VenueDao

    companion object {
        const val VENUES_TABLE_NAME = "venues"
        const val VENUES_DATABASE_NAME = "venues_database"
    }
}