package com.wayfair.themoviedb.feature.homepage

import dagger.Binds
import dagger.Module

@Module
abstract class HomepageScreenModule {
    @Binds
    internal abstract fun providesHomepagePresenter(presenter: HomepagePresenter): HomepageContract.Presenter

    @Binds
    internal abstract fun providesHomepageInteractor(interactor: HomepageInteractor): HomepageContract.Interactor

    @Binds
    internal abstract fun providesHomepageRepository(repository: HomepageRepository): HomepageContract.Repository

    @Binds
    internal abstract fun providesHomepageRouter(router: HomepageRouter): HomepageContract.Router
}
