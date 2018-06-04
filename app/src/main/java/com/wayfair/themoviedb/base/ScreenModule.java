package com.wayfair.themoviedb.base;

import com.wayfair.themoviedb.di.ForScreen;
import com.wayfair.themoviedb.di.ScreenScope;
import com.wayfair.themoviedb.lifecycle.DisposableManager;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ScreenModule {

    @Provides
    @ScreenScope
    @ForScreen
    static DisposableManager provideDisposableManager() {
        return new DisposableManager();
    }
}
