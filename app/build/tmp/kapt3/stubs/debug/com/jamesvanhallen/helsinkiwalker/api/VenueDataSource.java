package com.jamesvanhallen.helsinkiwalker.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/api/VenueDataSource;", "", "getAllVenues", "Lkotlinx/coroutines/Deferred;", "", "Lcom/jamesvanhallen/helsinkiwalker/model/database/venue/Venue;", "lat", "", "lon", "app_debug"})
public abstract interface VenueDataSource {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "venues")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.venue.Venue>> getAllVenues(@retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon);
}