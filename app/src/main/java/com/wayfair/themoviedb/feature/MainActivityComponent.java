package com.wayfair.themoviedb.feature;

import com.wayfair.themoviedb.di.ActivityScope;
import com.wayfair.themoviedb.ui.ActivityViewInterceptorModule;
import com.wayfair.themoviedb.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }
}
