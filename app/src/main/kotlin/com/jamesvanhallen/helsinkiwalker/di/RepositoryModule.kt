package com.jamesvanhallen.helsinkiwalker.di

import com.jamesvanhallen.helsinkiwalker.domain.database.AppDataBase
import com.jamesvanhallen.helsinkiwalker.domain.source.repository.VenueRepository
import com.jamesvanhallen.helsinkiwalker.domain.source.repository.VenueRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        VenueRepositoryImpl(
            get(),
            get<AppDataBase>().venueDao
        ) as VenueRepository
    }
}