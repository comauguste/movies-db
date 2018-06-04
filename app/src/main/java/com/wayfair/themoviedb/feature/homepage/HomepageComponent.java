package com.wayfair.themoviedb.feature.homepage;

import com.wayfair.themoviedb.base.ScreenModule;
import com.wayfair.themoviedb.di.ScreenComponent;
import com.wayfair.themoviedb.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent(modules = {
        ScreenModule.class,
        HomepageScreenModule.class,
})
public interface HomepageComponent extends ScreenComponent<HomepageFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomepageFragment> {

    }
}
