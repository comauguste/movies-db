package com.wayfair.themoviedb.feature.searchresults

import com.wayfair.themoviedb.di.ScreenScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SearchResultsScreenModule {
    @Binds
    abstract fun providesSearchResultsPresenter(presenter: SearchResultsPresenter): SearchResultsContract.Presenter

    @Binds
    abstract fun providesSearchResultsInteractor(interactor: SearchResultsInteractor): SearchResultsContract.Interactor

    @Binds
    abstract fun providesSearchResultsRepository(repository: SearchResultsRepository): SearchResultsContract.Repository

    @Binds
    abstract fun providesSearchResultsRouter(router: SearchResultsRouter): SearchResultsContract.Router

    @Module
    companion object {
        @JvmStatic
        @ScreenScope
        @Provides
        fun providesContext(fragment: SearchResultsFragment) = fragment.resources
    }
}
