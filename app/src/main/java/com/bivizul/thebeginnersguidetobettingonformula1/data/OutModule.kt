package com.bivizul.thebeginnersguidetobettingonformula1.data

import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.OUT_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OutModule {

    @Provides
    fun outUrl() = OUT_URL

    @Provides
    @Singleton
    fun provideOut() = Retrofit.Builder()
        .baseUrl(outUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(OutService::class.java)

}