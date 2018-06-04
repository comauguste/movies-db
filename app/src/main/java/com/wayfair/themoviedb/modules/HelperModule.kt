package com.pubbix.modules

import com.wayfair.themoviedb.util.rx.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HelperModule {
    @Provides
    @Singleton
    fun providesScheduler(): SchedulerProvider {
        return SchedulerProvider()
    }
}