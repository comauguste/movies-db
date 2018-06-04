package com.pubbix.base

import com.wayfair.themoviedb.data.remote.MovieDbApi
import com.wayfair.themoviedb.util.rx.scheduler.SchedulerProvider
import javax.inject.Inject

open class BaseRepository<I : Any> {
    @Inject
    protected lateinit var movieDbApi: MovieDbApi

    @Inject
    protected lateinit var schedulerProvider: SchedulerProvider
}