package com.wayfair.themoviedb.feature;

import android.support.v4.app.Fragment;

import com.wayfair.themoviedb.feature.detail.DetailComponent;
import com.wayfair.themoviedb.feature.detail.DetailFragment;
import com.wayfair.themoviedb.feature.homepage.HomepageComponent;
import com.wayfair.themoviedb.feature.homepage.HomepageFragment;
import com.wayfair.themoviedb.feature.searchresults.SearchResultsComponent;
import com.wayfair.themoviedb.feature.searchresults.SearchResultsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        HomepageComponent.class,
        SearchResultsComponent.class,
        DetailComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(HomepageFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindHomepageInjector(HomepageComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(SearchResultsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindSearchResultsInjector(SearchResultsComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(DetailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindDetailInjector(DetailComponent.Builder builder);
}
