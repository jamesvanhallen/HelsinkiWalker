package com.jamesvanhallen.helsinkiwalker.ui.venue;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/ui/venue/VenueViewModel;", "Landroidx/lifecycle/ViewModel;", "venueRepository", "Lcom/jamesvanhallen/helsinkiwalker/model/source/VenueRepository;", "(Lcom/jamesvanhallen/helsinkiwalker/model/source/VenueRepository;)V", "movies", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/jamesvanhallen/helsinkiwalker/model/database/venue/Venue;", "getMovies", "()Landroidx/lifecycle/MutableLiveData;", "onCreate", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class VenueViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue>> movies = null;
    private final com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository venueRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue>> getMovies() {
        return null;
    }
    
    private final kotlinx.coroutines.Job onCreate() {
        return null;
    }
    
    public VenueViewModel(@org.jetbrains.annotations.NotNull()
    com.jamesvanhallen.helsinkiwalker.model.source.VenueRepository venueRepository) {
        super();
    }
}