package com.jamesvanhallen.helsinkiwalker.model.database.venue

import com.google.gson.annotations.SerializedName

data class Venue(
    val id: Long,
    @SerializedName(NAME) val name: Long,
    @SerializedName(DESCRIPTION) val description: Long,
    @SerializedName(IMAGE) val image: Long

) {
    companion object {
        const val ID = "'/$'/oid"
        private const val NAME = "name"
        private const val DESCRIPTION = "short_description"
        private const val IMAGE = "listimage"
    }
}