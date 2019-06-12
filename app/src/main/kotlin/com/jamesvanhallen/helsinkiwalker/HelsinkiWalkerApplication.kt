package com.jamesvanhallen.helsinkiwalker

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.jamesvanhallen.helsinkiwalker.di.dataBaseModule
import com.jamesvanhallen.helsinkiwalker.di.dataSourceModule
import com.jamesvanhallen.helsinkiwalker.di.repositoryModule
import com.jamesvanhallen.helsinkiwalker.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Level

class HelsinkiWalkerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger(Level.DEBUG)
            } else {
                EmptyLogger()
            }
            androidContext(this@HelsinkiWalkerApplication)
            modules(
                listOf(
                    dataBaseModule, repositoryModule, viewModelModule, dataSourceModule
                )
            )
        }
    }
}