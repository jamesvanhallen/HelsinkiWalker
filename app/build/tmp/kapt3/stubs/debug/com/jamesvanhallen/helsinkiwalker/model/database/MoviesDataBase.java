package com.jamesvanhallen.helsinkiwalker.model.database;

import java.lang.System;

@androidx.room.Database(entities = {com.jamesvanhallen.helsinkiwalker.model.database.movie.Movie.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/model/database/MoviesDataBase;", "Landroidx/room/RoomDatabase;", "()V", "movieDao", "Lcom/jamesvanhallen/helsinkiwalker/model/database/movie/MovieDao;", "getMovieDao", "()Lcom/jamesvanhallen/helsinkiwalker/model/database/movie/MovieDao;", "Companion", "app_debug"})
public abstract class MoviesDataBase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOVIES_TABLE_NAME = "movies";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOVIES_DATABASE_NAME = "movies_database";
    public static final com.jamesvanhallen.helsinkiwalker.model.database.MoviesDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.jamesvanhallen.helsinkiwalker.model.database.movie.MovieDao getMovieDao();
    
    public MoviesDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/model/database/MoviesDataBase$Companion;", "", "()V", "MOVIES_DATABASE_NAME", "", "MOVIES_TABLE_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}