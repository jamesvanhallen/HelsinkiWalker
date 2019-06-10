package com.jamesvanhallen.helsinkiwalker.model.source.response

import com.google.gson.*
import com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue
import org.koin.core.KoinComponent
import org.koin.core.get
import java.lang.reflect.Type

class VenueDeserializer : JsonDeserializer<Venue>, KoinComponent {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Venue {

        //The deserialisation code is missing

        return get<Gson>().fromJson(json, Venue::class.java).apply {
            json.asJsonObject.get("active_menu").asJsonObject.get("")
        }
    }
}