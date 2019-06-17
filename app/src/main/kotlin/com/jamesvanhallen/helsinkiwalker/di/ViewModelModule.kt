package com.jamesvanhallen.helsinkiwalker.di

import com.jamesvanhallen.helsinkiwalker.presentation.venue.VenueViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        VenueViewModel(get())
    }
}