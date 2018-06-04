package com.wayfair.themoviedb.di;

import com.wayfair.themoviedb.lifecycle.DisposableManager;

import dagger.android.AndroidInjector;

public interface ScreenComponent<T> extends AndroidInjector<T> {

    @ForScreen
    DisposableManager disposableManager();
}
