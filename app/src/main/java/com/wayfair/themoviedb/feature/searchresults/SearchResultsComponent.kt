package com.wayfair.themoviedb.feature.searchresults

import com.wayfair.themoviedb.base.ScreenModule
import com.wayfair.themoviedb.di.ScreenComponent
import com.wayfair.themoviedb.di.ScreenScope

import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent(modules = [(ScreenModule::class), (SearchResultsScreenModule::class)])
interface SearchResultsComponent : ScreenComponent<SearchResultsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SearchResultsFragment>()
}
