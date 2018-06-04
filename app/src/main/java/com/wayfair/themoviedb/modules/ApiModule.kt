package com.pubbix.modules

import com.wayfair.themoviedb.data.remote.MovieDbApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    fun providesMovieDbApi(retrofit: Retrofit): MovieDbApi {
        return retrofit.create(MovieDbApi::class.java)
    }
}