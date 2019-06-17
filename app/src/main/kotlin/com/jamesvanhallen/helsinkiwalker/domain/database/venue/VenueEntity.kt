package com.jamesvanhallen.helsinkiwalker.domain.database.venue

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jamesvanhallen.helsinkiwalker.domain.database.AppDataBase

@Entity(tableName = AppDataBase.VENUES_TABLE_NAME)
data class VenueEntity(@PrimaryKey val id: String)