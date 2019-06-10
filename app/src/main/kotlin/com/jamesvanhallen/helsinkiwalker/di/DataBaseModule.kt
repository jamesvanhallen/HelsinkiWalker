package com.jamesvanhallen.helsinkiwalker.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jamesvanhallen.helsinkiwalker.model.database.MoviesDataBase
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            MoviesDataBase::class.java,
            MoviesDataBase.MOVIES_DATABASE_NAME
        )
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    get<VenueRepository>().setupDefault()
//                }
//            })
            .fallbackToDestructiveMigration()
            .build()
    }
}