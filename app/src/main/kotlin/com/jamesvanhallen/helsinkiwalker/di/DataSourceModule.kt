package com.jamesvanhallen.helsinkiwalker.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jamesvanhallen.helsinkiwalker.BuildConfig
import com.jamesvanhallen.helsinkiwalker.api.VenueDataSource
import com.jamesvanhallen.helsinkiwalker.domain.source.model.VenueDto
import com.jamesvanhallen.helsinkiwalker.domain.source.response.VenueDeserializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataSourceModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        GsonBuilder()
            .registerTypeAdapter(VenueDto::class.java, VenueDeserializer())
            .create()
    }

    factory {
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get<OkHttpClient.Builder>().build())
            .build()
        retrofit.create(VenueDataSource::class.java)
    }
}