package com.jamesvanhallen.helsinkiwalker.domain.source.response

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.jamesvanhallen.helsinkiwalker.extensions.EMPTY
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto
import java.lang.reflect.Type

class VenueDeserializer : JsonDeserializer<VenueDto> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): VenueDto {
        val id = json.asJsonObject.get(ACTIVE_MENU).asJsonObject.get(ID).asString
        val namesList = json.asJsonObject.get(NAME).asJsonArray
        var name = String.EMPTY
        if (namesList?.isJsonNull == false && namesList.size() > 0) {
            name = namesList[0].asJsonObject.get(VALUE).asString
        }
        val descriptionList = json.asJsonObject.get(DESCRIPTION).asJsonArray
        var description = String.EMPTY
        if (descriptionList?.isJsonNull == false && descriptionList.size() > 0) {
            description = descriptionList[0].asJsonObject.get(VALUE).asString
        }

        val image = json.asJsonObject.get(IMAGE).asString

        return VenueDto(id, name, description, image)
    }

    companion object {
        private const val ID = "\$oid"
        private const val NAME = "name"
        private const val DESCRIPTION = "short_description"
        private const val IMAGE = "listimage"
        private const val VALUE = "value"
        private const val ACTIVE_MENU = "active_menu"
    }
}