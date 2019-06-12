package com.jamesvanhallen.helsinkiwalker.di

import androidx.room.Room
import com.jamesvanhallen.helsinkiwalker.model.database.VenueDataBase
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            VenueDataBase::class.java,
            VenueDataBase.VENUES_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}