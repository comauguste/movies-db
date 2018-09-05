package com.wayfair.themoviedb.feature.homepage

import com.wayfair.themoviedb.base.ScreenModule
import com.wayfair.themoviedb.di.ScreenComponent
import com.wayfair.themoviedb.di.ScreenScope

import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent(modules = [(ScreenModule::class), (HomepageScreenModule::class)])
interface HomepageComponent : ScreenComponent<HomepageFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomepageFragment>()
}
