package com.wayfair.themoviedb.feature.homepage;

import com.wayfair.themoviedb.di.ScreenScope;
import com.wayfair.themoviedb.feature.searchresults.SearchResultsFragment;
import com.wayfair.themoviedb.ui.DefaultScreenNavigator;

import javax.inject.Inject;

@ScreenScope
public class HomepageRouter implements HomepageContract.Router {
    private DefaultScreenNavigator navigator;

    @Inject
    HomepageRouter(DefaultScreenNavigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void goToSearchPage(String searchTerms) {
        navigator.changeScreen(SearchResultsFragment.newInstance(searchTerms));
    }
}
