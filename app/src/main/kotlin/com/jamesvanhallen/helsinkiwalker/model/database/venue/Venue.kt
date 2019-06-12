package com.jamesvanhallen.helsinkiwalker.model.database.venue

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jamesvanhallen.helsinkiwalker.model.database.VenueDataBase.Companion.VENUES_TABLE_NAME

@Entity(tableName = VENUES_TABLE_NAME)
data class Venue(
    @PrimaryKey @ColumnInfo(name = ID) val uuid: String,
    @ColumnInfo(name = NAME) val name: String,
    @ColumnInfo(name = DESCRIPTION) val description: String,
    @ColumnInfo(name = IMAGE) val image: String,
    @ColumnInfo(name = FAVORITE) var isFavorite: Boolean
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Venue

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    companion object {
        private const val ID = "_id"
        private const val NAME = "name"
        private const val DESCRIPTION = "description"
        private const val IMAGE = "image"
        private const val FAVORITE = "favorite"
    }
}