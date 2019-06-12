package com.jamesvanhallen.helsinkiwalker.di

import com.jamesvanhallen.helsinkiwalker.model.database.VenueDataBase
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository
import com.jamesvanhallen.helsinkiwalker.model.source.VenueRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        VenueRepositoryImpl(get(), get<VenueDataBase>().movieDao) as VenueRepository
    }
}