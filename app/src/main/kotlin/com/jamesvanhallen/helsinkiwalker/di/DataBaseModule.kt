package com.jamesvanhallen.helsinkiwalker.di

import androidx.room.Room
import com.jamesvanhallen.helsinkiwalker.domain.database.AppDataBase
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            AppDataBase.VENUES_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}