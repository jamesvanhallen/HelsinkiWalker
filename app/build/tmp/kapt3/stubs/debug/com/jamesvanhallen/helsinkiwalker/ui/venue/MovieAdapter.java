package com.jamesvanhallen.helsinkiwalker.ui.venue;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/ui/venue/MovieAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jamesvanhallen/helsinkiwalker/ui/venue/MovieHolder;", "onRatioChangeListener", "Lkotlin/Function1;", "Lcom/jamesvanhallen/helsinkiwalker/model/database/movie/Movie;", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public final class MovieAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jamesvanhallen.helsinkiwalker.ui.venue.MovieHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie> items;
    private final kotlin.jvm.functions.Function1<com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie, kotlin.Unit> onRatioChangeListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jamesvanhallen.helsinkiwalker.ui.venue.MovieHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jamesvanhallen.helsinkiwalker.ui.venue.MovieHolder holder, int position) {
    }
    
    public MovieAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie, kotlin.Unit> onRatioChangeListener) {
        super();
    }
}