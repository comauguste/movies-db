package com.wayfair.themoviedb.feature.detail

import com.wayfair.themoviedb.base.ScreenModule
import com.wayfair.themoviedb.di.ScreenComponent
import com.wayfair.themoviedb.di.ScreenScope

import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent(modules = [(ScreenModule::class), (DetailScreenModule::class)])
interface DetailComponent : ScreenComponent<DetailFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailFragment>()
}
